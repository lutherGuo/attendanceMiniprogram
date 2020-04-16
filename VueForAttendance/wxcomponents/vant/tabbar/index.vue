<template>
<uni-shadow-root class="vant-tabbar-index"><view :class="'custom-class van-hairline--top-bottom '+(utils.bem('tabbar', { fixed, safe: isIPhoneX && safeAreaInsetBottom }))" :style="zIndex ? 'z-index: ' + zIndex : ''">
  <slot></slot>
</view></uni-shadow-root>
</template>
<wxs src="../wxs/utils.wxs" module="utils"></wxs>
<script>

global['__wxRoute'] = 'vant/tabbar/index'
import { VantComponent } from '../common/component';
import { safeArea } from '../mixins/safe-area';
VantComponent({
    mixins: [safeArea()],
    relation: {
        name: 'tabbar-item',
        type: 'descendant',
        linked(target) {
            this.children = this.children || [];
            this.children.push(target);
            this.setActiveItem();
        },
        unlinked(target) {
            this.children = this.children || [];
            this.children = this.children.filter(item => item !== target);
            this.setActiveItem();
        }
    },
    props: {
        active: Number,
        activeColor: String,
        fixed: {
            type: Boolean,
            value: true
        },
        zIndex: {
            type: Number,
            value: 1
        }
    },
    watch: {
        active(active) {
            this.currentActive = active;
            this.setActiveItem();
        }
    },
    created() {
        this.currentActive = this.data.active;
    },
    methods: {
        setActiveItem() {
            if (!Array.isArray(this.children) || !this.children.length) {
                return Promise.resolve();
            }
            return Promise.all(this.children.map((item, index) => item.setActive({
                active: index === this.currentActive,
                color: this.data.activeColor
            })));
        },
        onChange(child) {
            const active = (this.children || []).indexOf(child);
            if (active !== this.currentActive && active !== -1) {
                this.currentActive = active;
                this.setActiveItem().then(() => {
                    this.$emit('change', active);
                });
            }
        }
    }
});
export default global['__wxComponents']['vant/tabbar/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';.van-tabbar{display:-webkit-flex;display:flex;width:100%;height:50px;background-color:#fff}.van-tabbar--fixed{position:fixed;bottom:0;left:0}.van-tabbar--safe{padding-bottom:34px}
</style>