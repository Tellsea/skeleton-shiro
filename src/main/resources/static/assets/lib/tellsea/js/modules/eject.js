layui.define(["layer"], function (exports) {

    var $ = layui.jquery;

    /**
     * 序列化表单数据
     */
    $.fn.serializeJson = function () {
        var serializeObj = {};
        var array = this.serializeArray();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    };

    /**
     * 计算 屏幕 width：弹出层宽度 和 height：弹出层高度
     *
     * @type {{width: (function(): number), height: (function(): number)}}
     */
    var calc = {
        width: () => {
            return ($(window).width() * 0.9)
        }, height: () => {
            return ($(window).height() - 50)
        }
    };

    /**
     * 定义弹出层
     *
     * @type {{common: (function(*=, *, *=, *=, *=): s.index),
     *      form: (function(*=, *, *, *=, *=, *=): s.index),
     *      iframe: (function(*=, *=, *=, *=): s.index),
     *      close: close}}
     */
    var eject = {
        /**
         * 普通弹出层
         *
         * @param title    标题
         * @param pageId  节点id
         * @param isMax   是否最大化
         * @param w       宽度
         * @param h       高度
         * @returns {s.index}
         */
        common: (title = false, pageId, isMax = true, w = calc.width(), h = calc.height()) => {
            var index = layer.open({
                type: 1,
                title: title,
                content: $("#" + pageId),
                area: [w + 'px', h + 'px'],
                maxmin: isMax, // true 是最大化展示 false 不是最大化展示
                fix: false, //不固定
                shadeClose: true,
                scrollbar: false, // 是否带滚动 true 带滚动 false 不带滚动
                shade: 0.4,
            });
            return index;
        },
        /**
         * 表单弹出层
         *
         * @param title    标题
         * @param pageId  节点id
         * @param formId  表单id
         * @param isMax   是否最大化
         * @param w       宽度
         * @param h       高度
         * @returns {s.index}
         */
        form: (title = false, pageId, formId, yesFunc, isMax = true, w = calc.width(), h = calc.height()) => {
            var index = layer.open({
                type: 1,
                title: title,
                content: $("#" + pageId),
                area: [w + 'px', h + 'px'],
                maxmin: isMax, // true 是最大化展示 false 不是最大化展示
                fix: false, //不固定
                shadeClose: true,
                scrollbar: false, // 是否带滚动 true 带滚动 false 不带滚动
                shade: 0.4,
                btn: ["确定", "取消"],
                yes: yesFunc,
                end: function () {
                    $("#" + formId)[0].reset();
                    $("[name='sizeDiv']").remove();
                    $("#" + pageId).css("display", "none");
                    $(".layui-form-danger").removeClass("layui-form-danger");
                    $(".error").removeClass("error");
                }
            });
            return index;
        },
        /**
         * iframe 弹出层
         *
         * @param title  标题
         * @param url    路径
         * @param w      宽度
         * @param h      高度
         * @returns {s.index}
         */
        iframe: (title = false, url = "404.html", w = calc.width(), h = calc.height()) => {
            var index = layer.open({
                type: 2,
                area: [w + 'px', h + 'px'],
                fix: false, //不固定
                maxmin: true,
                shadeClose: true,
                shade: 0.4,
                title: title,
                content: url
            });
            return index;
        },
        close: function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        }
    };
    exports("eject", eject);
});
