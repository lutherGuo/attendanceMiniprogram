<template>
<uni-shadow-root class="vant-notify-index"><van-transition name="slide-down" :show="show" custom-class="van-notify" :custom-style="'background-color:'+(backgroundColor)+'; color: '+(color)+';'">
  <view v-if="safeAreaInsetTop" class="van-notify__safe-top" :style="'padding-top: '+(statusBarHeight)+'px'"></view>
  {{ text }}
</van-transition></uni-shadow-root>
</template>

<script>
import VanTransition from '../transition/index.vue'
global['__wxVueOptions'] = {components:{'van-transition': VanTransition}}

global['__wxRoute'] = 'vant/notify/index'
import { VantComponent } from '../common/component';
import { RED } from '../common/color';
import { safeArea } from '../mixins/safe-area';
VantComponent({
    mixins: [safeArea()],
    props: {
        text: String,
        color: {
            type: String,
            value: '#fff'
        },
        backgroundColor: {
            type: String,
            value: RED
        },
        duration: {
            type: Number,
            value: 3000
        }
    },
    methods: {
        showNotify() {
            const { duration } = this.data;
            clearTimeout(this.timer);
            this.set({
                show: true
            });
            if (duration > 0 && duration !== Infinity) {
                this.timer = setTimeout(() => {
                    this.hide();
                }, duration);
            }
        },
        hide() {
            clearTimeout(this.timer);
            this.set({
                show: false
            });
        }
    }
});
export default global['__wxComponents']['vant/notify/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';.van-notify{position:fixed;top:0;z-index:110;width:100%;padding:6px 15px;font-size:14px;line-height:20px;text-align:center;word-break:break-all;box-sizing:border-box}.van-notify__safe-top{height:44px}
</style>