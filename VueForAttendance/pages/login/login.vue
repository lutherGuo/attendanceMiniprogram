<template>
	<view >
		<!-- #ifdef MP-WEIXIN -->
		<button type="primary" open-type="getUserInfo" @getuserinfo="getuserinfo" withCredentials="true">微信登录</button>
		<!-- #endif -->

		<!-- #ifdef APP-PLUS -->
		<button type="primary" open-type="getUserInfo" @click="getuserinfo" withCredentials="true">微信登录</button>
		<!-- #endif -->

		<button style=" margin-top:50px;">手机号码登录</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userInfo:[]
			}
		},
		methods: {
			getuserinfo: function(res) {
				if (!res.detail.iv) {
					uni.showToast({
						title: "求求你授权吧"
					})
					return false;
				}
				console.log(res)
				this.userInfo=res.detail.userInfo
				// 调用云函数获取openid
				wx.cloud.callFunction({
					name: 'login',
					data: {},
					success: res => {
						console.log('[云函数] [login] user openid: ', res.result.openid)
						this.userInfo.openid = res.result.openid
						uni.setStorageSync("userInfo",this.userInfo)
						console.log(uni.getStorage("userInfo"))
						uni.navigateTo({
							url:"../index/index"
						})
					},
					fail: err => {
						console.error('[云函数] [login] 调用失败', err)
					},
				})
			}

		}
	}
</script>

<style>

</style>
