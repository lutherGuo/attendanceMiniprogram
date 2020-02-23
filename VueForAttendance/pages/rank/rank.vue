<template>
	<view @click="conClick" v-if="userInfo.realNameInfo">
		<clickCircle ref="clickCircle"></clickCircle>

		<view class="space" >
			<block v-if="AllUserTime">
				<view class="bg-img bg-mask flex align-center" :style="{backgroundImage:'url('+AllUserTime[0].avatarUrl+')'}" style="height: 500upx;">
					<view class="padding-xl text-white">

						<view class="flex   align-center">
							<view class="cu-avatar radius " :style="{backgroundImage:'url('+AllUserTime[0].avatarUrl+')'}"></view>
							<view class="padding-sm text-xxl text-bold">
								{{AllUserTime[0].nickName}}占领了今天的封面
							</view>
						</view>

						<view class="padding-xs text-lg">
							总时长:{{AllUserTime[0].time|TimeToString}}
						</view>
					</view>
				</view>


				<view class="cu-list menu-avatar ">
					<block v-for="(item,index) in AllUserTime" :key="index">
						<view v-if="item.uId==userInfo.uId" class="cu-item bg-black">
							<view class="cu-avatar radius lg" :style="{backgroundImage:'url('+item.avatarUrl+')'}">
								<view class="cu-tag badge lg">{{index+1}}</view>
							</view>
							<view class="content">
								<view class="text-black text-bold text-xxl">{{item.nickName}}</view>

							</view>
							<view class="action">
								<view class="text-orange text-bold text-xl">{{item.time|TimeToString}}</view>
							</view>
							<view class="move">
								<view class="bg-grey">置顶</view>
								<view class="bg-red">关注</view>
							</view>
						</view>
					</block>
				</view>


				<view class="cu-list menu-avatar ">
					<view class="cu-item " style="border:10rpx" :class="modalName=='move-box-'+ index?'move-cur':''" v-for="(item,index) in AllUserTime"
					 :key="index" @touchstart="ListTouchStart" @touchmove="ListTouchMove" @touchend="ListTouchEnd" :data-target="'move-box-' + index">

						<view class="cu-avatar radius lg" :style="{backgroundImage:'url('+item.avatarUrl+')'}">
							<view class="cu-tag badge green">{{index+1}}</view>
						</view>
						<view class="content">
							<view class="text-black text-bold text-xxl">{{item.nickName}}</view>

						</view>
						<view class="action">
							<view class="text-bold text-xl" :class="index<3?'text-orange':'text-black'">{{item.time|TimeToString}}</view>

						</view>
						<view class="move">
							<view class="bg-grey">置顶</view>
							<view class="bg-red">关注</view>
						</view>
					</view>
				
				</view>







			</block>
			</view>
		</view>
</template>

<script>
	import clickCircle from '../../components/zwy/clickCircle.vue';
	export default {
		components: {

			clickCircle
		},
		data() {
			return {
				modalName: null,
				AllUserTime: [{
					"time": ""
				}],
				userInfo: {}
			}
		},

		onLoad() {

		},
		onShow() {
			this.isLogin()
			if (this.userInfo.uId != null) {
				this.getAllUserTime()
			}else if (this.userInfo &&this.userInfo.realNameInfo==null){
				uni.showModal({
					title: "请先实名",
					showCancel: false,
					success: function(res) {
						if (res.confirm) {
							console.log("确定了啊")
							uni.switchTab({
								url: "/pages/profile/profile"
							})
						}

					}
				})
			}

		},
		filters: {
			TimeToString: function(value) {
				var hour = Math.floor(value / 60)
				var minute = value % 60
				if (hour < 10) {
					hour = "0" + hour + ":"
				} else {
					hour = hour + ":"
				}
				if (minute < 10) {
					minute = "0" + minute
				}

				return hour + minute
			}
		},
		methods: {
			conClick(e) {
				this.$refs.clickCircle.conClick(e);
			},
			// 判断登录
			isLogin() {
				this.userInfo = global.isLogin();
				console.log(this.userInfo)
				if (!this.userInfo) {
					uni.showModal({
						title: "请先登录",
						showCancel: false,
						success: function(res) {
							if (res.confirm) {
								console.log("确定了啊")
								uni.switchTab({
									url: "/pages/profile/profile"
								})
							}

						}
					})
				}
			},
			getAllUserTime() {
				var that = this;
				uni.request({
					url: "https://api.lifeisgg.online/attendance/time/getAllUserTime",
					success(res) {
						console.log(res.data)
						that.AllUserTime = res.data.allUserTime
						console.log(that.AllUserTime)
					}
				})
			},
			// ListTouch触摸开始
			ListTouchStart(e) {
				this.listTouchStart = e.touches[0].pageX
			},

			// ListTouch计算方向
			ListTouchMove(e) {
				this.listTouchDirection = e.touches[0].pageX - this.listTouchStart > 0 ? 'right' : 'left'
			},

			// ListTouch计算滚动
			ListTouchEnd(e) {
				if (this.listTouchDirection == 'left') {
					this.modalName = e.currentTarget.dataset.target
				} else {
					this.modalName = null
				}
				this.listTouchDirection = null
			}
		},

	}
</script>

<style>

</style>
