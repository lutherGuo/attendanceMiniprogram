<template>
	<view v-if="userInfo.realNameInfo">

		<view class="cu-modal show" v-if="!roomLog">
			<view class="cu-dialog">
				<picker @change="PickerChange" :range-key="'rName'" :value="index" :range="pickRoomList">
					<view class="picker">
						<view class="padding flex flex-direction">
							<button class="cu-btn  bg-green lg shadow" @click="getRoomList">模拟指纹进入教室</button>
						</view>
					</view>
				</picker>
			</view>



		</view>



		<block v-if="roomLog">
			<!-- 回到顶部悬浮按钮 -->
			<movable-area style="height: 100vh; width: 100vw;position: absolute;bottom: 0;">
				<movable-view class="addBtnBox" style="padding-top:120upx;padding-bottom:50upx;" @touchmove.stop="" :x="isX" :y="isY"
				 direction="all">
					<view class="addBtn" @click="toTop">TOP</view>
				</movable-view>
			</movable-area>

			<view style="position: fixed;width: 100%;z-index: 100;">
				<view class="bg-img bg-mask flex align-center" style="background-image:url(https://ossweb-img.qq.com/images/lol/web201310/skin/big10006.jpg);height: 400upx;">
					<view class="padding-xl text-white">
						<view class=" text-sl text-bold">
							{{roomLog[0].rName}}
						</view>
						<view class="padding-xs text-lg">
							在线人数:20人
						</view>
						<button class="cu-btn lg green" @click="exitRoom">
							<view class="cuIcon-exit"></view>
						</button>
					</view>
				</view>
			</view>

			<view style="position: absolute;top: 400upx;;width: 100%;">

				<view class="cu-timeline " v-for="(item,index) in roomLog" :key="index">
					<view class="text-grey text-lg">{{item.lDate | getYMD}}</view>
					<view class="cu-item " :class="item.state==1?'text-green':'text-blue'">
						<view class="shadow-blur content" :class="item.state==1?'bg-green':'bg-blue'">
							<view class="cu-list menu-avatar radius">
								<view class="cu-item">
									<view class="cu-avatar radius lg" :style="{backgroundImage:'url('+item.avatarUrl+')'}"></view>
									<view class="content">
										<view>
											<view class="text-bold text-xl text-black">{{item.nickName}}</view>
											<view class="cu-tag radius sm " :class="item.state==1?'bg-green':'bg-blue'">{{item.state==1?'进':'出'}}</view>
										</view>
										<view class="text-gray text-sm flex">
											<view class="text-cut"> 通过指纹进入</view>
										</view>

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








		</block>






	</view>
</template>

<script>
	const util = require('../../components/zwy/util/util.js');
	import clickCircle from '../../components/zwy/clickCircle.vue';
	import moment from 'moment'


	export default {
		components: {
			clickCircle
		},
		data() {
			return {
				roomLog: {},
				userInfo: {},
				isX: 999, //放在store统一管理
				isY: 999, //放在store统一管理
				toView: '',
				showPicker: true,
				pickRoomList: [],
				chooseRoom: "",
				MsgInfo: {}


			}
		},
		onShow() {

			console.log(moment().format('YYYY-MM-DD HH:mm:ss'));
			this.isLogin()

			if (!this.userInfo.realNameInfo) {

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
			} else {
				this.getRoom()
				this.getRoomList()
			}
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
		methods: {

			conClick(e) {
				this.$refs.clickCircle.conClick(e);
			},
			toTop() {
				this.toView = ''
				setTimeout(() => {
					this.toView = 'top' + this.currentTab
				}, 10)
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
			getRoom() {
				var that = this;
				uni.request({
					url: "https://impl.lifeisgg.online/attendance/home/home",
					data: {
						"uId": that.userInfo.uId,
						"rId": "",
						"state": "",
						"lDate": ""
					},
					success(res) {
						console.log(res.data)
						that.roomLog = res.data.roomLog
						if (that.roomLog) {
							uni.showToast({
								title: "欢迎进入" + that.roomLog[0].rName,
								icon: "none"
							})
						}

					}
				})
			},
			PickerChange(e) {
				this.index = e.detail
				console.log(e.detail.value)
				this.chooseRoom = this.pickRoomList[e.detail.value].rId
				console.log(this.chooseRoom)
				this.entryRoom()
			},
			getRoomList() {
				var that = this;
				uni.request({
					url: "https://impl.lifeisgg.online/attendance/room/room",
					success(res) {
						that.pickRoomList = res.data.roomList
						console.log(that.pickRoomList)
					}
				})

			},
			getMsg(e) {
				console.log("e=" + e.date)
				wx.cloud.callFunction({
					name: 'sendMsg',
					data: {
						"info": e
					},
					success(res) {
						console.log(res);
						wx.showToast({
							title: '发送成功!',
						})

					},
					fail(err) {
						console.log(err);
						wx.showToast({
							title: '发送失败!',
						})
					}
				})
			},
			sendMsg: function(e) {
			    wx.requestSubscribeMessage({
			      tmplIds: [
			        'jxm2u-gMXptrgJBsHOThe9-1L4Vw2dghG7J05FLEEKk',
			      ],
			      success(res) {
			        console.log(res)
			      },
			      fail(err) {
			        console.log(err);
			      }
			    })
			  },
			entryRoom() {
				var that = this;
				let now = moment().format('YYYY-MM-DD HH:mm:ss')
				uni.request({
					url: "https://impl.lifeisgg.online/attendance/home/home",
					data: {
						"uId": that.userInfo.uId,
						"rId": that.chooseRoom,
						"state": 1,
						"lDate": now
					},
					success(res) {
						console.log(res.data)
						that.roomLog = res.data.roomLog

						that.MsgInfo.nickName = that.userInfo.nickName
						that.MsgInfo.title = "进入" 
						that.MsgInfo.address = that.roomLog[0].address
						that.MsgInfo.remind = "无"
						that.MsgInfo.date = now
						console.log("info" + that.MsgInfo.date)
						that.sendMsg()
						that.getMsg(that.MsgInfo)

					}
				})
			},
			exitRoom() {
				var that = this;
				uni.showModal({
					title: "确定要退出吗",
					success: function(res) {
						if (res.confirm) {
							let now = moment().format('YYYY-MM-DD HH:mm:ss')
							let rName = that.roomLog[0].rName
							let address = that.roomLog[0].address
							let rId = that.roomLog[0].rId
							uni.request({
								url: "https://impl.lifeisgg.online/attendance/home/home",
								data: {
									"uId": that.userInfo.uId,
									"rId": rId,
									"state": 0,
									"lDate": now
								},
								success(res) {
									console.log(res.data.success)
									that.roomLog = res.data.roomLog

									that.MsgInfo.nickName = that.userInfo.nickName
									that.MsgInfo.title = "退出"
									that.MsgInfo.address = address
									that.MsgInfo.remind = "无"
									that.MsgInfo.date = now
									console.log("info" + that.MsgInfo.date)
									that.sendMsg()
									that.getMsg(that.MsgInfo)

								}
							})

						}


					}
				})


			}
		}
	}
</script>

<style>
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
	.addBtnBox {
		position: fixed;
		z-index: 900;
		width: 140upx;
		align-items: flex-end;
		justify-content: center;
		height: 140upx;
		display: flex;
	}
</style>
