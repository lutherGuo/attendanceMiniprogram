<template>
<uni-shadow-root class="vant-rate-index"><view class="van-rate custom-class" @touchmove="onTouchMove">
  <van-icon v-for="(item,index) in (list)" :key="item.index" class="van-rate__item" custom-class="icon-class" :size="(size)+'px'" :data-index="index" :name="item ? icon : voidIcon" :color="disabled ? disabledColor : item ? color : voidColor" @click="onSelect"></van-icon>
</view></uni-shadow-root>
</template>

<script>
import VanIcon from '../icon/index.vue'
global['__wxVueOptions'] = {components:{'van-icon': VanIcon}}

global['__wxRoute'] = 'vant/rate/index'
import { VantComponent } from '../common/component';
VantComponent({
    field: true,
    classes: ['icon-class'],
    props: {
        readonly: Boolean,
        disabled: Boolean,
        size: {
            type: Number,
            value: 20
        },
        icon: {
            type: String,
            value: 'star'
        },
        voidIcon: {
            type: String,
            value: 'star-o'
        },
        color: {
            type: String,
            value: '#ffd21e'
        },
        voidColor: {
            type: String,
            value: '#c7c7c7'
        },
        disabledColor: {
            type: String,
            value: '#bdbdbd'
        },
        count: {
            type: Number,
            value: 5
        },
        value: {
            type: Number,
            value: 0
        }
    },
    data: {
        innerValue: 0
    },
    watch: {
        value(value) {
            if (value !== this.data.innerValue) {
                this.set({ innerValue: value });
            }
        }
    },
    computed: {
        list() {
            const { count, innerValue } = this.data;
            return Array.from({ length: count }, (_, index) => index < innerValue);
        }
    },
    methods: {
        onSelect(event) {
            const { data } = this;
            const { index } = event.currentTarget.dataset;
            if (!data.disabled && !data.readonly) {
                this.set({ innerValue: index + 1 });
                this.$emit('input', index + 1);
                this.$emit('change', index + 1);
            }
        },
        onTouchMove(event) {
            const { clientX, clientY } = event.touches[0];
            this.getRect('.van-rate__item', true).then(list => {
                const target = list.find(item => clientX >= item.left &&
                    clientX <= item.right &&
                    clientY >= item.top &&
                    clientY <= item.bottom);
                if (target != null) {
                    this.onSelect(Object.assign({}, event, { currentTarget: target }));
                }
            });
        }
    }
});
export default global['__wxComponents']['vant/rate/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';.van-rate{-webkit-user-select:none;user-select:none}.van-rate__item{width:1em;padding:0 2px;box-sizing:initial}
</style>