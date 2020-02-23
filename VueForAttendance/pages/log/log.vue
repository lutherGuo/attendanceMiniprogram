<template>
	<view @click="conClick" v-if="userInfo.realNameInfo">
		<cu-custom bgColor="bg-blue">
			<block slot="content">日志</block>
		</cu-custom>

		<clickCircle ref="clickCircle"></clickCircle>

		<view class="container999" @touchstart="refreshStart" @touchmove="refreshMove" @touchend="refreshEnd">
			<!-- 刷新组件需搭配scroll-view使用，并在pages.json中添加 "disableScroll":true-->
			<refresh ref="refresh" @isRefresh='isRefresh'></refresh>
			<view class='nav' style="top:this.CustomBar+30upx">
				<!-- 导航栏 agents导航栏标题 -->
				<navTab ref="navTab" :tabTitle="tabTitle" @changeTab='changeTab'>日志</navTab>
			</view>
			<!-- 回到顶部悬浮按钮 -->
			<movable-area style="height: 100vh; width: 100vw;position: absolute;bottom: 0;">
				<movable-view class="addBtnBox" style="padding-top:120upx;padding-bottom:50upx;" @touchmove.stop="" :x="isX" :y="isY"
				 direction="all">
					<view class="addBtn" @click="toTop">TOP</view>
				</movable-view>
			</movable-area>
			<!-- swiper切换 swiper-item表示一页 scroll-view表示滚动视窗 -->
			<swiper style="min-height: 100vh;" :current="currentTab" @change="swiperTab">
				<swiper-item v-for="(listItem,listIndex) in list" :key="listIndex">
					<!-- @scrolltolower="lower1" -->
					<scroll-view style="height: 100%;" scroll-y="true" scroll-with-animation :scroll-into-view="toView">
						<view :id="'top'+listIndex" style="width: 100%;height: 100upx;"></view>



						<view v-for="(item,index) in listItem" :key="index">
							<!-- 我的日志 -->
							<view class="cu-timeline padding-sm" v-if="listIndex==0">
								<view class="text-grey text-lg">{{item.lDate | getYMD}}</view>
								<view class="cu-item " :class="item.state==1?'text-green':'text-blue'">
									<view class="shadow-blur content" :class="item.state==1?'bg-green':'bg-blue'">
										<view class="cu-list menu-avatar radius">
											<view class="cu-item">
												<view class="cu-avatar lg radius " :class="item.state==1?'bg-green':'bg-blue'">{{item.state==1?'进':'出'}}</view>
												<view class="content">
													<view class="cu-capsule radius">
														<view class="cu-tag bg-red text-sm">
															<text class="cuIcon-location"></text>
														</view>
														<view class="cu-tag line-red  text-sm">{{item.rName}}</view>
													</view>
													<view class="text-grey text-xs">通过指纹进入</view>


												</view>
												<view class="action">
													<view class="text-grey text-lg">{{item.lDate | getHm}}</view>
													<view class="text-grey text-lg">星期{{item.lDate | getDay}}</view>
												</view>
											</view>

										</view>
									</view>
								</view>
							</view>
							
							

							<!-- 我的教室 -->
							<view class="cu-card article" v-if="listIndex==1" @tap="showModal" data-target="logDetail" :data-rId="item.rId" >
								<view class="cu-item shadow">
									<view class="title">
										<view class="text-cut">{{item.rName}}</view>
									</view>
									<view class="content">
										<image src="https://ossweb-img.qq.com/images/lol/web201310/skin/big10006.jpg" mode="aspectFill"></image>
										<view class="desc">
											<view class="text-content"> 折磨生出苦难，苦难又会加剧折磨，凡间这无穷的循环，将有我来终结！真正的恩典因不完整而美丽，因情感而真诚，因脆弱而自由！</view>
											<view>
												<view class="cu-capsule radius">
													<view class="cu-tag bg-blue xs">
														<text class="cuIcon-location"></text>
													</view>
													<view class="cu-tag line-blue  xs">{{item.address}}</view>
												</view>
											</view>
										</view>
									</view>
								</view>
							</view>
						</view>

					</scroll-view>
				</swiper-item>
			</swiper>
		</view>

		<!-- 我的教室详细日志 -->
		<view class="cu-modal" :class="modalName=='logDetail'?'show':''">

			<view class="cu-dialog">

				<view class="cu-bar bg-white justify-end">
					<view class="content">我在{{myRoomLog[0].rName}}的日志</view>
					<view class="action" @tap="hideModal">
						<text class="cuIcon-roundclose text-red text-xxl"></text>
					</view>
				</view>

				<!-- 我的教室详细日志 -->
				<scroll-view style="height: 800upx;" scroll-y="true">
					<view v-for="(item,index) in myRoomLog" :key="index">
						<view class="cu-timeline padding-sm">
							<view class="text-grey ">{{item.lDate | getYMD}}</view>
							<view class="cu-item " :class="item.state==1?'text-green':'text-blue'">
								<view class="shadow-blur content" :class="item.state==1?'bg-green':'bg-blue'">
									<view class="cu-list menu-avatar radius">
										<view class="cu-item">
											<view class="cu-avatar lg radius " :class="item.state==1?'bg-green':'bg-blue'">{{item.state==1?'进':'出'}}</view>
											<view class="content">
												<view class="cu-capsule radius">
													<view class="cu-tag bg-red text-sm">
														<text class="cuIcon-location"></text>
													</view>
													<view class="cu-tag line-red  text-sm">{{item.rName}}</view>
												</view>
												<view class="text-grey text-xs">通过指纹进入</view>


											</view>
											<view class="action">
												<view class="text-grey text-lg">{{item.lDate | getHm}}</view>
												<view class="text-grey text-lg">星期{{item.lDate | getDay}}</view>
											</view>
										</view>

									</view>
								</view>
							</view>
						</view>
					</view>

					<view class="text-gray card-menu padding-sm">共{{this.myRoomLog | getLength}}条日志</view>
				</scroll-view>
			</view>






		</view>

	</view>

</template>

<script>
	const util = require('../../components/zwy/util/util.js');
	import moment from 'moment'
	import refresh from '../../components/zwy/refresh.vue';
	import navTab from '../../components/zwy/navTab.vue';
	import clickCircle from '../../components/zwy/clickCircle.vue';

	export default {
		components: {
			refresh,
			navTab,
			clickCircle
		},
		data() {
			return {
				toView: '', //回到顶部id
				isX: 999, //放在store统一管理
				isY: 999, //放在store统一管理
				tabTitle: ['我的日志', '我的教室'], //导航栏格式 --导航栏组件
				currentTab: 0, //sweiper所在页
				pages: [1, 1], //第几个swiper的第几页
				list: [], //数据格式
				myLogList: [],
				roomList: [],
				userInfo: {},
				myRoomLog: {},
				modalName: ""
			}
		},
		computed: {

		},
		// 转化毫秒时间戳为日期格式
		filters: {
			getYMD: function(value) {
				return moment(value).format('YYYY-MM-DD')
			},
			getHm: function(value) {
				return moment(value).format('HH:mm')
			},
			getDay: function(value) {
				return moment(value).format('E')
			},
			getLength: function(value) {
				return value.length
			}
		},
		onLoad() {

		},
		onShow() {
			this.isLogin()
			if (this.userInfo && this.userInfo.realNameInfo != null) {
				this.getLog()
			} else if (this.userInfo && this.userInfo.realNameInfo == null) {
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

			getLog() {
				var that = this;

				uni.request({
					url: "https://api.lifeisgg.online/attendance/log/getLog",
					data: {
						"uId": that.userInfo.uId,
						"rId": ""
					},
					success(res) {
						console.log(res.data)
						that.myLogList = res.data.logList
						// for(let i = 0;i<that.myLogList.length;i++){
						// 	that.myLogList[i].lDate = moment(res.data.logList[0].lDate).format('YYYY-MM-DD-dd HH:mm:ss')
						// }				
						that.roomList = res.data.roomList
						that.list[0] = that.myLogList.reverse()
						that.list[1] = that.roomList.reverse()
						console.log(that.list)
						uni.showToast({
							title: "获取日志成功"
						})

					}
				})


			},
			// 获取我的教室日志详细信息
			getMyRoomDetail(rId) {
				console.log(rId)
				var that = this
				if (that.userInfo.uId && rId) {
					uni.request({
						url: "https://api.lifeisgg.online/attendance/log/getLog",
						data: {
							"uId": that.userInfo.uId,
							"rId": rId
						},
						success(res) {
							console.log(res)
							that.myRoomLog = res.data.logList.reverse()
							uni.showToast({
								title: "获取成功"
							})

						}
					})
				} else {
					uni.showToast({
						title: "获取失败"
					})
				}
			},

			showModal(e) {
				console.log(e.currentTarget.dataset)
				if (e.currentTarget.dataset.rid) {
					this.getMyRoomDetail(e.currentTarget.dataset.rid)
				}
				this.modalName = e.currentTarget.dataset.target
			},
			hideModal(e) {
				this.modalName = null
			},


			// 逆序输出日志
			// reverseLog: function(value) {
			// 	var list = this.list[0].reverse()
			// 	return this.list
			// },



			toTop() {
				this.toView = ''
				setTimeout(() => {
					this.toView = 'top' + this.currentTab
				}, 10)
			},
			changeTab(index) {
				this.currentTab = index
			},
			// 其他请求事件 当然刷新和其他请求可以写一起 多一层判断。
			isRequest(pages) {
				return new Promise((resolve, reject) => {
					this.pages[this.currentTab]++
					var that = this
					setTimeout(() => {
						uni.hideLoading()
						uni.showToast({
							icon: 'none',
							title: `请求第${that.currentTab + 1 }个导航栏的第${that.pages[that.currentTab]}页数据成功`
						})
						let newData = ['新数据1', '新数据2']
						resolve(newData)
					}, 1000)
				})
			},
			// swiper 滑动
			swiperTab: function(e) {
				var index = e.detail.current //获取索引
				this.$refs.navTab.longClick(index);
			},
			// 加载更多 util.throttle为防抖函数
			lower1: util.throttle(function(e) {
				console.log(`加载${this.currentTab}`) //currentTab表示当前所在页数 根据当前所在页数发起请求并带上page页数
				uni.showLoading({
					title: '加载中',
					mask: true
				})
				this.isRequest().then((res) => {
					let tempList = this.list
					tempList[this.currentTab] = tempList[this.currentTab].concat(res)
					console.log(tempList)
					this.list = tempList
					this.$forceUpdate() //二维数组，开启强制渲染
				})
			}, 300),
			// 刷新touch监听
			refreshStart(e) {
				this.$refs.refresh.refreshStart(e);
			},
			refreshMove(e) {
				this.$refs.refresh.refreshMove(e);
			},
			refreshEnd(e) {
				this.$refs.refresh.refreshEnd(e);
			},
			isRefresh() {
				setTimeout(() => {
					uni.showToast({
						icon: 'success',
						title: '刷新成功'
					})
					this.$refs.refresh.endAfter() //刷新结束调用
				}, 1000)
			}
		}
	}
</script>

<style>
	.addBtnBox {
		position: fixed;
		z-index: 900;
		width: 140upx;
		align-items: flex-end;
		justify-content: center;
		height: 140upx;
		display: flex;
	}

	.addBtn {
		width: 100upx;
		height: 100upx;
		border-radius: 50%;
		color: white;
		font-size: 10px;
		font-weight: bold;
		background: #444857;
		line-height: 100upx;
		text-align: center;
		box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
	}

	.container999 {
		width: 100vw;
		font-size: 28upx;
		min-height: 100vh;
		overflow: hidden;
		color: #6B8082;
		position: relative;
		background-color: #f6f6f6;
	}

	.content {
		width: 100%;
	}

	.card {
		width: 90%;
		height: 368upx;
		background-color: white;
		margin: 0 auto 42upx auto;
		background: #FFFFFF;
		box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.10);
		border-radius: 5px;
		position: relative;
	}

	.noCard {
		width: 90%;
		height: 200upx;
		margin: auto;
		background-color: white;
		display: flex;
		align-items: center;
		justify-content: center;
		color: #999999;
		box-shadow: 0 0 10upx 0 rgba(0, 0, 0, 0.10);
		border-radius: 10upx;
	}


	.nav {
		position: fixed;
		left: 0;
		color: white;
		width: 100%;
		display: flex;
		flex-direction: column;
		align-items: flex-start;
		justify-content: flex-start;
		font-size: 24upx;
		background-color: #0081ff;
		z-index: 996;
	}



	.input999 {
		color: #999;
		width: 80%;
	}
</style>
