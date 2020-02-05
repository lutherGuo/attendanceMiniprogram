<template>
	<view @click="conClick">
		<clickCircle ref="clickCircle"></clickCircle>
		
		
		

		
	

				<scroll-view scroll-y class="page">
					
					<swiper class="card-swiper round-dot"  :indicator-dots="true" :circular="true"
					 :autoplay="true" interval="5000" duration="500" @change="cardSwiper" indicator-color="#8799a3"
					 indicator-active-color="#0081ff">
						<swiper-item v-for="(item,index) in swiperList" :key="index" :class="cardCur==index?'cur':''">
							<view class="swiper-item">
								<image :src="item.url" mode="aspectFill" v-if="item.type=='image'"></image>
								<video :src="item.url" autoplay loop muted :show-play-btn="false" :controls="false" objectFit="cover" v-if="item.type=='video'"></video>
							</view>
						</swiper-item>
					</swiper>
					
				<view class="nav-list">
					<navigator hover-class="none" :url="'/pages/charge/' + item.name" class="nav-li" navigateTo :class="'bg-'+item.color"
					 :style="[{animation: 'show ' + ((index+1)*0.2+1) + 's 1'}]" v-for="(item,index) in elements" :key="index">
						<view class="nav-title">{{item.title}}</view>
						<view class="nav-name">{{item.name}}</view>
						<text :class="'cuIcon-' + item.cuIcon"></text>
					</navigator>
				</view>
				</scroll-view>
		

	
		
		
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
				swiperList: [{
					id: 0,
					type: 'image',
					url: 'http://www.lingnan.edu.cn/images/2019-12-31.jpg'
				}, {
					id: 1,
					type: 'image',
					url: 'http://www.lingnan.edu.cn/images/2020-1-3.jpg',
				}, {
					id: 2,
					type: 'image',
					url: 'http://www.lingnan.edu.cn/images/9-16-1.jpg'
				}, {
					id: 3,
					type: 'image',
					url: 'http://www.lingnan.edu.cn/images/9-25-1.jpg'
				}],
				elements: [{
						title: '教室',
						name: 'roomList',
						color: 'cyan',
						cuIcon: 'brandfill'
					},
					{
						title: '用户',
						name: 'user',
						color: 'blue',
						cuIcon: 'peoplelist'
					},
					{
						title: '日志',
						name: 'text',
						color: 'purple',
						cuIcon: 'time'
					},
					{
						title: 'Geek',
						name: 'icon',
						color: 'mauve',
						cuIcon: 'discover'
					}
					
					
				]
			}
		},
		methods: {
			conClick(e) {
				this.$refs.clickCircle.conClick(e);
			},
			cardSwiper(e) {
				this.cardCur = e.detail.current
			}
		}
	}
</script>

<style>
	.page {
		height: 100vh;
	}
		
	
</style>
