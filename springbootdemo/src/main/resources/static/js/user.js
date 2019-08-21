var dataVue = {
    user: {
        id: "",
        username: "",
        password: ""
    },
    userList: [{
        id: "1",
        username: "大佬",//模拟的数据
        password: "123"
    }],
    pageInfo: {
        // pageNum: "",//当前页
        // pageSize: "",//每页的数量
        // size: "",//当前页的数量
        // pages: "",//总页数
        // prePage: "",//前一页
        // nextPage: "",//下一页
        // navigatepageNums: [],//所有导航页号
        // hasPreviousPage: "",//是否有前一页
        // hasNextPage: ""//是否有下一页
    }
};
new Vue({
    el: "#app",
    data: dataVue,
    created: function () {//当页面加载的时候触发请求,查询所有
        this.findAll(1);
    },
    methods: {
        findAll: function (start) {//查询所有
            var _this = this;//在当前方法中定义一个对象,表明是vue对象
            axios.get('user/findAll', {
                params: {
                    start: start
                }
            })
                .then(function (response) {
                    _this.userList = response.data.list;//响应数据给userList赋值
                    _this.pageInfo = response.data;
                })
                .catch(function (error) {//出现异常则打印
                    console.log(error);
                })
        },
        findById: function (userid) {//根据ID查询
            var _this = this;
            axios.get('user/findById', {
                params: {//这是get请求参数的写法
                    id: userid
                }
            })
                .then(function (response) {
                    _this.user = response.data;//响应数据给userList赋值
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        addUser: function () {//新增
            var _this = this;
            axios.post('user/addUser', _this.user)//这是post请求参数的写法
                .then(function () {//无返回值,所以无response
                    _this.findAll(1);
                    _this.user.username = "";
                    _this.user.password = "";
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        update: function () {//更新
            var _this = this;
            axios.post('user/updateUser', _this.user)//这是post请求参数的写法
                .then(function () {//无返回值,所以无response
                    _this.findAll(_this.pageInfo.pageNum);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        deleteById: function (userid, index) {//根据ID删除
            var _this = this;
            var param = new URLSearchParams();
            param.append('id', userid);//解决后端接收不到参数的问题
            axios.post('user/deleteById', param)
                .then(function () {
                    _this.userList.splice(index, 1);//根据id删除userList中的数据
                    // _this.findAll();
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        jump: function (page) {//跳转首页,尾页,上一页,下一页
            if ('first' == page && 1 != this.pageInfo.pageNum)
                this.findAll(1);

            else if ('pre' == page && this.pageInfo.hasPreviousPage)
                this.findAll(this.pageInfo.prePage);

            else if ('next' == page && this.pageInfo.hasNextPage)
                this.findAll(this.pageInfo.nextPage);

            else if ('last' == page && this.pageInfo.pageNum != this.pageInfo.pages)
                this.findAll(this.pageInfo.pages);

        },
        jumpByNumber: function (start) {//跳转到指定页面
            if (start != this.pageInfo.pageNum)
                this.findAll(start);
        },
        refresh:function () {//刷新当前页面
            this.findAll(this.pageInfo.pageNum);
        }
    }
});