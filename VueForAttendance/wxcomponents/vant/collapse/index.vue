<template>
<uni-shadow-root class="vant-collapse-index"><view :class="'custom-class van-collapse '+(border ? 'van-hairline--top-bottom' : '')">
  <slot></slot>
</view></uni-shadow-root>
</template>

<script>

global['__wxRoute'] = 'vant/collapse/index'
import { VantComponent } from '../common/component';
VantComponent({
    relation: {
        name: 'collapse-item',
        type: 'descendant',
        linked(child) {
            this.set({
                items: [...this.data.items, child]
            }, () => {
                child.updateExpanded();
            });
        }
    },
    props: {
        value: null,
        accordion: Boolean,
        border: {
            type: Boolean,
            value: true
        }
    },
    data: {
        items: []
    },
    watch: {
        value() {
            this.data.items.forEach(child => {
                child.updateExpanded();
            });
        },
        accordion() {
            this.data.items.forEach(child => {
                child.updateExpanded();
            });
        }
    },
    methods: {
        switch(name, expanded) {
            const { accordion, value } = this.data;
            if (!accordion) {
                name = expanded
                    ? value.concat(name)
                    : value.filter(activeName => activeName !== name);
            }
            else {
                name = expanded ? name : '';
            }
            this.$emit('change', name);
            this.$emit('input', name);
        }
    }
});
export default global['__wxComponents']['vant/collapse/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';
</style>