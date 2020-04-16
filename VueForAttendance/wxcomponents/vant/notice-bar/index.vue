<template>
<uni-shadow-root class="vant-notice-bar-index"><view v-if="show" :class="'custom-class van-notice-bar '+(hasRightIcon ? 'van-notice-bar--within-icon' : '')" :style="'color: '+(color)+'; background-color: '+(backgroundColor)+';'" @click="onClick">
  <view v-if="leftIcon" class="van-notice-bar__left-icon">
    <image :src="leftIcon"></image>
  </view>
  <view class="van-notice-bar__content-wrap">
    <view :class="'van-notice-bar__content '+(scrollable ? '' : 'van-ellipsis')" :animation="animationData">
      {{ text }}
    </view>
  </view>

  <van-icon v-if="mode === 'closeable'" class="van-notice-bar__right-icon" name="cross" @click.native="onClickIcon"></van-icon>
  <navigator v-if="mode === 'link'" :url="url" :open-type="openType">
    <van-icon class="van-notice-bar__right-icon" name="arrow"></van-icon>
  </navigator>
</view></uni-shadow-root>
</template>

<script>
import VanIcon from '../icon/index.vue'
global['__wxVueOptions'] = {components:{'van-icon': VanIcon}}

global['__wxRoute'] = 'vant/notice-bar/index'
import { VantComponent } from '../common/component';
const FONT_COLOR = '#ed6a0c';
const BG_COLOR = '#fffbe8';
VantComponent({
    props: {
        text: {
            type: String,
            value: ''
        },
        mode: {
            type: String,
            value: ''
        },
        url: {
            type: String,
            value: ''
        },
        openType: {
            type: String,
            value: 'navigate'
        },
        delay: {
            type: Number,
            value: 0
        },
        speed: {
            type: Number,
            value: 50
        },
        scrollable: {
            type: Boolean,
            value: true
        },
        leftIcon: {
            type: String,
            value: ''
        },
        color: {
            type: String,
            value: FONT_COLOR
        },
        backgroundColor: {
            type: String,
            value: BG_COLOR
        }
    },
    data: {
        show: true,
        hasRightIcon: false
    },
    watch: {
        text() {
            this.set({}, this.init);
        }
    },
    created() {
        if (this.data.mode) {
            this.set({
                hasRightIcon: true
            });
        }
        this.resetAnimation = wx.createAnimation({
            duration: 0,
            timingFunction: 'linear'
        });
    },
    destroyed() {
        this.timer && clearTimeout(this.timer);
    },
    methods: {
        init() {
            Promise.all([
                this.getRect('.van-notice-bar__content'),
                this.getRect('.van-notice-bar__content-wrap')
            ]).then((rects) => {
                const [contentRect, wrapRect] = rects;
                if (contentRect == null ||
                    wrapRect == null ||
                    !contentRect.width ||
                    !wrapRect.width) {
                    return;
                }
                const { speed, scrollable, delay } = this.data;
                if (scrollable && wrapRect.width < contentRect.width) {
                    const duration = (contentRect.width / speed) * 1000;
                    this.wrapWidth = wrapRect.width;
                    this.contentWidth = contentRect.width;
                    this.duration = duration;
                    this.animation = wx.createAnimation({
                        duration,
                        timingFunction: 'linear',
                        delay
                    });
                    this.scroll();
                }
            });
        },
        scroll() {
            this.timer && clearTimeout(this.timer);
            this.timer = null;
            this.set({
                animationData: this.resetAnimation
                    .translateX(this.wrapWidth)
                    .step()
                    .export()
            });
            setTimeout(() => {
                this.set({
                    animationData: this.animation
                        .translateX(-this.contentWidth)
                        .step()
                        .export()
                });
            }, 20);
            this.timer = setTimeout(() => {
                this.scroll();
            }, this.duration);
        },
        onClickIcon() {
            this.timer && clearTimeout(this.timer);
            this.timer = null;
            this.set({ show: false });
        },
        onClick(event) {
            this.$emit('click', event);
        }
    }
});
export default global['__wxComponents']['vant/notice-bar/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';.van-notice-bar{display:-webkit-flex;display:flex;height:40px;padding:0 15px;font-size:14px;line-height:24px;-webkit-align-items:center;align-items:center}.van-notice-bar--within-icon{position:relative;padding-right:40px}.van-notice-bar__left-icon{height:18px;min-width:20px;box-sizing:border-box}.van-notice-bar__left-icon>image{width:16px;height:16px}.van-notice-bar__right-icon{position:absolute;top:10px;right:15px;font-size:16px}.van-notice-bar__content-wrap{position:relative;height:24px;overflow:hidden;-webkit-flex:1;flex:1}.van-notice-bar__content{position:absolute;white-space:nowrap}.van-notice-bar__content.van-ellipsis{max-width:100%}
</style>