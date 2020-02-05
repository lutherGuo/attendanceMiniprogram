<template>
	<view class="container" @click="conClick">
		<clickCircle ref="clickCircle"></clickCircle>
		<cu-custom bgColor="bg-blue">
		</cu-custom>
		<view></view>
		<!-- <home></home> -->
		<button @click="addGlobal">值为{{this.wxUserInfo}}</button>
		<navigator url="../home/home">跳转</navigator>
		
<!-- 		<view class="cu-modal show" v-if="!userInfo">
		  <view class="cu-dialog">
		    </view>
			<navigator url="../profile/profile">
		    <button class="cu-btn block bg-green lg shadow" >清先登录</button>
			</navigator>
		  </view>
		</view> -->
		
		
	</view>
</template>

<script>
	import clickCircle from '../../components/zwy/zwy-clickCircle.vue';
	import home from '../../pages/home/home.vue'
	export default {
		components: {
			clickCircle,
			home
		},
		data() {
			return {
				userInfo:[]
			};
		},
		onLoad() {
			this.isLogin();
			this.springTest();
		},
		methods: {
			// 判断登录
			isLogin(){
				var userInfo = global.isLogin();
				console.log(this.userInfo)
				if(!this.userInfo){
					uni.showModal({
						title:"未登录",
						success:function(){
							uni.navigateTo({
								url:"/pages/profile/profile"
							})
						}
					})
				}
			},
			
			// 调用springboot接口实例
			springTest(){
				uni.request({
					url:"http://localhost:8080/attendencyMiniprogram/log/getLogByRid/1",
					success(res){
						console.log(res.data)
					}
				})
			},
			
			conClick(e) {
				this.$refs.clickCircle.conClick(e);
			},
			addGlobal(){
				console.log(this.wxUserInfo)
				if(!this.wxUserInfo){
					this.wxUserInfo=1
				}
				
				this.wxUserInfo++
			}
		}
	}
</script>

<style>
	.container{
		width: 100vw;
		font-size: 28upx;
		min-height: 100vh;
		overflow: hidden;
		color: #6B8082;
		position: relative;
		background-color: #f6f6f6;
	}
</style>
