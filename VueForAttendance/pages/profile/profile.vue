<template>
	<view @click="conClick">
		<!-- 登录模块 -->
		<!-- 		<cu-custom bgColor="bg-gradual-pink" v-if="!userInfo">
			<block slot="content">登录模块</block>
		</cu-custom> -->
		<clickCircle ref="clickCircle"></clickCircle>
		<view class="space">


		<view class="cu-modal show" v-if="!userInfo">
			<view class="cu-dialog">
				<van-button v-if="!userInfo" icon="file" type="primary" size="large" open-type="getUserInfo" @getuserinfo="getUserinfo">微信一键登录</van-button>
			</view>
		</view>

		<van-notify id="van-notify"></van-notify>


		<!-- 用户显示界面 -->
		<!-- 'https://i.loli.net/2019/11/16/HOnxavlZ2z5Kfri.jpg' -->

		<view v-if="userInfo" class="bg-img bg-mask flex align-end" style="background-image: url('https://i.loli.net/2019/11/16/HOnxavlZ2z5Kfri.jpg');height: 400upx;">
			<view class="bg-shadeCenter padding  flex  align-start">
				<!-- #ifdef MP-WEIXIN -->
				<!-- {{userInfo.avatarUrl}} -->
				<view class="cu-avatar xl radius" :style="{backgroundImage:'url('+userInfo.avatarUrl+')'}">
					<view class="cu-tag badge" :class="userInfo.gender==1?'cuIcon-male bg-blue':'cuIcon-female bg-pink'">
					</view>
				</view>
				<!-- #endif -->

				<view class="grid col-1">
					<view class=" padding-left-sm radius text-bold text-white text-xl">{{userInfo.nickName}}</view>
					<view class="cu-capsule radius padding-sm padding-top-lg">
						<view class="cu-tag bg-blue xl">
							<text class="cuIcon-people "></text>
						</view>
						<view class="cu-tag line-white xl " v-if="userInfo.sSuper==0">
							超管
						</view>
						<view class="cu-tag line-white xl " v-else>
							普通用户
						</view>
					</view>
				</view>
			</view>
		</view>



		<!-- 小菜单 -->

		<view class="cu-list menu card-menu margin-top sm-border" v-if="userInfo">
			<view class="cu-item arrow" @tap="showModal" data-target="realName">

				<view class="content">
					<text class="cuIcon-peoplefill text-red text-xl "></text>
					<text class="text-grey">实名认证</text>
				</view>
				<view class="action">
					<view class="cu-tag round bg-blue" v-if="userInfo.realNameInfo">已实名</view>
					<view class="cu-tag round bg-red" v-if="!userInfo.realNameInfo">未实名</view>
				</view>

			</view>
			
			<view class="cu-item" >
				<view class="content">
					<text class="cuIcon-btn text-green"></text>
					<text class="text-grey">接收消息</text>
				</view>
				<view class="action">
					<switch class='green radius'  @click="wakeUpMsg" @change="SwitchSendMsg" :class="userInfo.sendMsg?'checked':''" :checked="userInfo.sendMsg?true:false"></switch>
				</view>
			</view>
			


			<view class="cu-item arrow">
				<button class="cu-btn content" open-type="contact">
					<text class="cuIcon-service text-olive text-xl"></text>
					<text class="text-grey">客服</text>
				</button>
			</view>

			<view class="cu-item arrow" @tap="exitLogin">
				<button class="cu-btn content">
					<text class="cuIcon-exit text-olive text-xl"></text>
					<text class="text-grey">退出登录</text>
				</button>
			</view>
		</view>
		
<!-- 		<button @click="sendMsg">订阅消息</button>
		<button @click="getMsg">发送消息</button> -->

		</view>


		<!-- 实名认证有就显示，没有就填写 -->
		<!-- v-if="!userInfo.realNameInfo" -->
		<van-toast id="van-toast" />
		<view class="cu-modal" :class="modalName=='realName'?'show':''">

			<view class="cu-dialog" v-if="!userInfo.realNameInfo">
				<view class="cu-bar bg-white justify-end">
					<view class="content">岭师实名认证</view>
					<view class="action" @tap="hideModal">
						<text class="cuIcon-roundclose text-red text-xxl"></text>
					</view>
				</view>

				<form @submit="realNameSubmit" class="padding-sm">

					<view class="cu-form-group">
						<text class="cuIcon-people text-red text-xl"></text>
						<view class="title">学号</view>
						<input placeholder="真实学号" name="sId"></input>
					</view>



					<view class="cu-form-group">
						<text class="cuIcon-command text-green text-xl"></text>
						<view class="title">密码</view>
						<input password="" placeholder="默认123456" name="pwd"></input>
					</view>
					<!-- 						<view class="cu-form-group">
							<text class="cuIcon-phone text-blue text-xl"></text>
							<view class="title">手机</view>
							<input placeholder="todo:手机号码验证" name="pNumber"></input>
							<view class="cu-capsule radius">
								<view class='cu-tag bg-blue '>
									+86
								</view>

							</view>
						</view> -->
					<view class="cu-form-group">
						<text class="cuIcon-mail text-green text-xl"></text>
						<view class="title">邮箱</view>
						<input placeholder="todo:邮箱验证" name="email"></input>
						<button class='cu-btn bg-green shadow'>验证码</button>
					</view>

					<button class="cu-btn lg shadow bg-gradual-green" form-type="submit">确认绑定</button>
				</form>
			</view>



			<view class="cu-dialog" v-if="userInfo.realNameInfo">
				<view class="cu-bar bg-white justify-end">
					<view class="content">岭师实名认证</view>
					<view class="action" @tap="hideModal">
						<text class="cuIcon-roundclose text-red text-xxl"></text>
					</view>
				</view>

				<view class="cu-list menu card-menu margin-top sm-border">
					<view class="cu-item">
						<button class="cu-btn content" open-type="contact">
							<text class="cuIcon-btn text-olive text-xl"></text>
							<text class="">id：{{userInfo.realNameInfo.uId}}</text>
						</button>
					</view>

					<view class="cu-item">
						<button class="cu-btn content" open-type="contact">
							<text class="cuIcon-peoplefill text-olive text-xl"></text>
							<text class="">学号：{{userInfo.realNameInfo.sId}}</text>
						</button>
					</view>

					<view class="cu-item">
						<button class="cu-btn content" open-type="contact">
							<text class="cuIcon-phone text-olive text-xl"></text>
							<text class="">电话：{{userInfo.realNameInfo.pNumber}}</text>
						</button>
					</view>

					<view class="cu-item">
						<button class="cu-btn content">
							<text class="cuIcon-mail text-olive text-xl"></text>
							<text class="">邮箱：{{userInfo.realNameInfo.email}}</text>
						</button>
					</view>

				</view>

			</view>





		</view>

	</view>
</template>

<script>
	import Notify from '../../wxcomponents/vant/notify/notify.js'
	import Toast from '../../wxcomponents/vant/toast/toast';
	import clickCircle from '../../components/zwy/clickCircle.vue';

	export default {
		components: {

			clickCircle
		},
		data() {
			return {
				show: true,
				modalName: null,
				realNameInfo: null,
				userInfo: {},
				wxUser: {},
				switchMsg:"",
			}
		},
		onLoad() {
			console.log("onLoad()")
			
		},
		onShow() {
			this.userInfo = uni.getStorageSync("userInfo")
			console.log("onShow()")

			if (!this.userInfo) {
				this.warnNotify()
			} else {
				// 每次都要更新的
				this.getUidAndSuper()
				// this.getRealName()

			}
		},
		methods: {
			SwitchSendMsg(e) {
				this.switchMsg = e.detail.value
				this.userInfo.switchMsg = this.switchMsg
				console.log("that.userInfo.switchMsg="+this.userInfo.switchMsg)
				if(this.userInfo.switchMsg==true){

				}
			},
			wakeUpMsg(){
				if(this.userInfo.switchMsg==true){
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
				}
			},
			conClick(e) {
				this.$refs.clickCircle.conClick(e);
			},
			warnNotify() {
				Notify({
					text: "未登录",
					duration: 1000,
					backgroundColor: 'blue',
					position: "bottom"
				})

			},
			successNotify(title) {
				Notify({
					backgroundColor: 'green',
					text: title,
					position: "bottom"
				});

			},
			onTowast(mes) {
				Toast("adad")
			},

			showModal(e) {
				this.modalName = e.currentTarget.dataset.target
			},
			hideModal(e) {
				this.modalName = null
			},

			exitLogin() {
				var that = this;
				uni.showModal({
					title: "确定要退出吗",
					success: function(res) {
						if (res.confirm) {
							that.userInfo = null;
							uni.setStorageSync("userInfo", null);
							console.log(that.userInfo)
						}


					}
				})
			},
			getUidAndSuper() {
				console.log("that.userInfo.uId=" + this.userInfo)
				var that = this;
				uni.request({
					url: "https://api.lifeisgg.online/attendance/wxUser/login",
					data: {
						"openId": that.userInfo.openid,
						"avatarUrl": that.userInfo.avatarUrl,
						"nickName": that.userInfo.nickName
					},
					// header:{
					// 	"Content-Type":'applicantion/json'
					// },
					success(res) {

						let title = "";
						let icon = "success";
						console.log(res.data.success)
						that.userInfo.uId = res.data.wxUserInfo.uId
						that.userInfo.sSuper = res.data.wxUserInfo.sSuper
						uni.request({
							url: "https://api.lifeisgg.online/attendance/realName/getRealName",
							data: {
								"uId": that.userInfo.uId
							},
							success(res) {
								console.log(res.data)
								that.realNameInfo = res.data.realNameInfo
								that.userInfo.realNameInfo = res.data.realNameInfo

								uni.setStorageSync("userInfo", that.userInfo)
								that.userInfo = uni.getStorageSync("userInfo")

							}
						})

						if (res.data.success != false) {
							if (res.data.success == null) {
								if (res.data.wxUserInfo.sSuper == 0) {
									title = "欢迎回来超管"
								} else {
									title = "欢迎回来"
								}

							} else if (res.data.success == true) {
								title = "欢迎您加入岭师考勤系统"
							}

						} else {
							title = "失败",
								icon = "none"
						}
						that.successNotify(title)
						console.log(res)
					}
				})

			},

			getRealName() {
				var that = this;

				console.log("that.userInfo.uId=" + this.userInfo)
				uni.request({
					url: "https://api.lifeisgg.online/attendance/realName/getRealName",
					data: {
						"uId": that.userInfo.uId
					},
					success(res) {
						console.log(res.data)
						that.realNameInfo = res.data.realNameInfo
						that.userInfo.realNameInfo = res.data.realNameInfo

						uni.setStorageSync("userInfo", that.userInfo)
						that.userInfo = uni.getStorageSync("userInfo")

					}
				})
			},

			getUserinfo: function(res) {
				var that = this;
				if (!res.detail.iv) {
					uni.showToast({
						title: "求求你授权吧"
					})
					return false;
				}
				console.log(res)
				that.userInfo = res.detail.userInfo
				// 调用云函数获取openid
				wx.cloud.callFunction({
					name: 'login',
					data: {},
					success: res => {
						console.log('[云函数] [login] user openid: ', res.result.openid)
						that.userInfo.openid = res.result.openid
						that.switchMsg = true
						that.userInfo.switchMsg = true


						that.getUidAndSuper()
						// console.log("that.userInfo.sSper:::"+that.userInfo.sSper)
						// that.getRealName()
						// uni.setStorageSync("userInfo", that.userInfo)
					},
					fail: err => {
						console.error('[云函数] [login] 调用失败', err)
					}
				})

			},



			realNameSubmit: function(e) {
				var that = this;
				console.log(e.detail.value)
				let sId = e.detail.value.sId
				let pwd = e.detail.value.pwd
				let email = e.detail.value.email


				if ((!sId || !pwd) || !email) {
					// this.onTowast("请填写完整")
					uni.showToast({
						title: "请填写完整",
						icon: "none"
					})
					return false
				}
				uni.request({
					url: "https://api.lifeisgg.online/attendance/realName/tieRealName",
					data: {
						"uId": that.userInfo.uId,
						"sId": e.detail.value.sId,
						"password": e.detail.value.pwd,
						"email": e.detail.value.email
					},
					success(res) {
						let title = "";

						console.log(res.data.success)
						let msg = res.data.success;
						if (msg == "tied") {
							title = "此学号已绑定"
						} else if (msg == "noExist") {
							title = "账号不存在或密码错误"
						} else if (msg == true) {
							title = "绑定成功"
							that.hideModal()
							that.getRealName()
						} else {
							title = "绑定失败"
						}
						uni.showToast({
							title: title,
							icon: "none"
						})
						that.successNotify(title)
					}
				})

			},
			
			sendMsg: function(e) {
			    wx.requestSubscribeMessage({
			      tmplIds: [
			        'il9K_JqyWPEIKbIHaSMHMvRM3BYAMt_UC6gCVERpXjU',
			      ],
			      success(res) {
			        console.log(res)
			      },
			      fail(err) {
			        console.log(err);
			      }
			    })
			  },
			
			    getMsg: function() {
			      wx.cloud.callFunction({
			        name: 'sendMsg',
			        data: {
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

		}
	}
</script>

<style>

</style>
