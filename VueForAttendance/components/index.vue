<template>
	<view class="container" @click="conClick">
		<clickCircle ref="clickCircle"></clickCircle>
	</view>
</template>

<script>
	import clickCircle from '../components/zwy-clickCircle/zwy-clickCircle.vue';
	export default {
		components: {
			clickCircle
		},
		data() {
			return {

			};
		},
		onLoad() {

		},
		methods: {
			conClick(e) {
				this.$refs.clickCircle.conClick(e);
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
