/**
 * @author tellsea
 * @version v0.0.1
 * @description javascript 常用工具类
 * @date: 2019/7/5 15:30
 */
var validator = {

    /**
     * 非空验证
     *
     * @param val
     * @returns {boolean}
     */
    isEmpty(val) {
        if (val == undefined || val == null || val == '') {
            return true;
        } else {
            return false;
        }
    },

    /**
     * 邮箱验证
     *
     * @param val
     * @returns {boolean}
     */
    isEmail(val) {
        var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
        return reg.test(val);
    },

    /**
     * 身份证号码验证
     *
     * @param val
     * @returns {boolean}
     * 身份证正则表达式(15位):isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
     * 身份证正则表达式(18位):isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
     */
    isCard(val) {
        var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        return reg.test(val);
    },

    /**
     * 手机号码
     *
     * @param val
     * @returns {boolean}
     */
    isPhone(val) {
        var reg = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
        return reg.test(val);
    },

    /**
     * 固定电话
     *
     * @param val
     * @returns {boolean}
     */
    isLandline(val) {
        var reg = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;
        return reg.test(val);
    },

    /**
     * 手机号码或者固定电话
     *
     * @param val
     * @returns {boolean}
     */
    isPhoneOrLandline(val) {
        var reg = /^((0\d{2,3}-\d{7,8})|(1[3456789]\d{9}))$/;
        return reg.test(val);
    },

    /**
     * 邮编
     *
     * @param val
     * @returns {boolean}
     */
    isPostalcode(val) {
        var reg = /^[1-9][0-9]{5}$/;
        return reg.test(val);
    },

    /**
     * 银行卡号，15,16,19位
     *
     * @param val
     * @returns {boolean}
     */
    isBank(val) {
        var reg = /^([1-9]{1})(\d{14}|\d{18}|\d{15})$/;
        return reg.test(val);
    },
};
