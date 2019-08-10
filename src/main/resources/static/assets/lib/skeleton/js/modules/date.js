/**
 * // 默认控件
 * //初始化日期范围控件controlId（控件ID）,tag,type,fmt（日期格式）
 * @param controlId（控件ID,必传）
 * @param range（两个日期的分隔符，必传，为true时，默认为“-”，为false时则关闭日期范围选择）
 * @param type（日期类型，可选：year,month,date,time,datetime）
 * @param fmt（日期格式:yyyy-MM-dd HH:mm:ss,可选,格式可任意搭配，如：yyyy、y、MM、M等）
 *  时间范围控制 min="", max=""
 */
var laydateCtrl = {
    defaultDate: (controlId, type = "date", fmt = "yyyy-MM-dd", range = false, min = "", max = "", value = "") => {
        let time = {elem: '#' + controlId, calendar: true, range: range, type: type, format: fmt};
        if (min != "" || max != "") {
            time = Object.assign(time, {min: min, max: max});
        }
        if (value != "") {
            time = Object.assign(time, {value: value});
        }
        laydate.render(time);
    },

    /**
     * 时间类型的日期控件
     * @param controlId
     * @param second 默认为true，传入false时不带秒
     */
    dateTimeControl: (controlId, second = true) => {
        let fmt = "yyyy-MM-dd HH:mm";
        second == true ? fmt = "yyyy-MM-dd HH:mm:ss" : fmt = "yyyy-MM-dd HH:mm";
        laydateCtrl.defaultDate(controlId, "datetime", fmt);
    },

    /**
     * 日期类型的日期控件
     * @param controlId
     */
    dateControl: (controlId) => {
        laydateCtrl.defaultDate(controlId);
    },

    /**
     * 范围日期类型的日期控件
     * @param controlId
     */
    dateRangeControl: (controlId) => {
        laydateCtrl.defaultDate(controlId, "date", "yyyy-MM-dd", true);
    },

    /**
     * 范围日期时间类型的日期控件
     * @param controlId
     */
    dateTimeRangeControl: (controlId) => {
        laydateCtrl.defaultDate(controlId, "datetime", "yyyy-MM-dd HH:mm:ss", true);
    },
};
