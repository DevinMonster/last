function product() {
    this.totlePrice = 0;
    this.products = [];
    this.meuns = [];
    this.outputinfo = []
}

function car() {
    this.title = "";
    this.price = 0;
    this.img = '';
    this.num = 0;
}

var product = new product();

$("#mediaBody").on("click", function () {
    $("#toggleBody").css("display", "block");
    $("#sumX").text(1);
})
$("#toggleClose").on("click", function () {
    $("#toggleBody").css("display", "none");
})

$("#calcDeck").on("click", function () {
    $res = Number($("#sumX").text());
    // console.log($res);
    if ($res <= 1) return;
    $("#sumX").text($res - 1);
})

$("#calcAdd").on("click", function () {
    $res = Number($("#sumX").text());
    $("#sumX").text($res + 1);
})

$openModel = null;
$imgName = null;
$itemId = null;


$("#addCar").on("click", function () {
    $num = Number($("#sumX").text());
    $money = Number($("#priceToggle").text().split("¥")[1]);
    $title = $("#toggleTitle").text();
    $img = $imgName;

    var flag = true;
    for (i = 0; i < product.outputinfo.length; i++) {
        if (product.outputinfo[i].id === $itemId) {
            product.outputinfo[i].num += $num;
            flag = false;
        }
    }
    if (flag) {
        var car = {};
        car.img = $img;
        car.price = $money;
        car.title = $title;
        car.num = $num;
        car.id = $itemId;
        product.outputinfo.push(car);
    }
    product.totlePrice += $money;
    $("#totalPricr").text("总价：¥" + product.totlePrice.toFixed(2));
    if (isNaN($openModel.children().last().prev().text())) {
        $openModel.children().last().before('<button class="btn btn-info btn-desc">-</button><span id="sumOne">' + $num +
            '</span>');
        $("#badgeX").text(Number($("#badgeX").text()) + $num)

        $(".btn-desc").on("click", function () {
            $price = Number($(this).siblings(":first").text().split("¥")[1]);
            alert($price);
            product.totlePrice -= $price;
            $("#totalPricr").text("总价：¥" + product.totlePrice.toFixed(2));
            $res = Number($(this).next().text()) - 1
            $("#badgeX").text(Number($("#badgeX").text()) - 1)
            $(this).next().text($res);
            for (i = 0; i < product.outputinfo.length; i++) {
                if (product.outputinfo[i].id === $itemId) {
                    product.outputinfo[i].num -= $num;
                    if (product.outputinfo[i].num === 0) {
                        product.outputinfo.splice(i, 1);
                    }
                }
            }
            if ($res < 1) {
                $(this).next().remove();
                $(this).remove();
            }
        })
    } else {
        $("#badgeX").text(Number($("#badgeX").text()) + $num)
        $openModel.children().last().prev().text(Number($openModel.children().last().prev().text()) + $num);
    }


    $("#toggleBody").css("display", "none");
})

$("#calcBtn").on("click", function () {
    if (product.outputinfo.length === 0) {
        $("#carTabBody").append('<tr colspan="3"><td align="center">购物车空空如也</td></tr>');
        $("#toOrder").css("display", "none");
        return;
    }
    $("#carTabBody").children().remove();
    $("#toOrder").css("display", "block");
    // console.log(product.outputinfo);
    for (i = 0; i < product.outputinfo.length; i++) {
        $("#carTabBody").append('<tr><td style="width: 20%;"><img src="' + product.outputinfo[i].img + '" class="media-img" /></td><td><p>名称：' + product.outputinfo[i].title + '</p><p>数量：' + product.outputinfo[i].num + '</p><p>单价：' + product.outputinfo[i].price + ' ¥</p><p>一共：' + Number(product.outputinfo[i].price) * Number(product.outputinfo[i].num) + ' ¥</p></td><td><input type="checkbox" class="form-check-input" id="exampleCheck1"></td></tr>')
    }
})
// 页面初始化加载
$(document).ready(function () {
    $bodyh = $(window).height(); //浏览器当前窗口文档body的高度
    $topnav = $("#topNav").outerHeight(true);
    $lastnav = $("#lastNav").outerHeight(true);
    $result = $bodyh - $topnav - $lastnav;
    // console.log($bodyh);
    // console.log($topnav);
    // console.log($lastnav);
    $("#contentX").css("height", $result);
    $("#listColX").css("height", $result);
    $("#contentColX").css("height", $result);
    $("#listColX").css("background", "rgba(230,230,230,0.7)");
    $("#collapseBtnCalc").css("bottom", $lastnav)

    // 1. 判断是否登录
    var item = sessionStorage.getItem("token");
    // 说明起码是有token的
    if (item !== null) {
        // 用户名
        let name = sessionStorage.getItem("username");
        // 头像
        let picurl = sessionStorage.getItem("userpic");
        console.log(picurl);
        $("#login").remove();
        $("#register").remove();
        $("#nav_login_reg")
            .append('<button type="button" class="btn btn-link" id="login"> 欢迎!'+ name + '</button>')
            .append('<img class="rounded-circle" style="width: 40px;height: 40px;" src="' + picurl +'"/>');
    }



    product.meuns = ["喜茶实验室", "当季限定", "人气必喝", "喜茶制冰", "热饮推荐", "果茶家族", "名茶/牛乳茶", "啵啵家族", "喜茶咖啡", "纯茶", "加料", "早餐组合"];
    product.products = [{
        "id": 1,
        "title": "喜小瓶无糖气泡水",
        "content": "口味升级，专注纯粹果香；容量升级，加量不加价；设计升级，重塑全新流畅瓶型。清新果香唤醒味蕾，纤维添加，不止含糖",
        "price": "5.5",
        "img": ["./image/WechatIMG33.jpeg", "./image/WechatIMG32.jpeg"]
    }, {
        "id": 2,
        "title": "忙忙碌碌",
        "content": "口味升级，专注纯粹果香；容量升级，加量不加价；设计升级，重塑全新流畅瓶型。清新果香唤醒味蕾，纤维添加，不止含糖",
        "price": "5.5",
        "img": ["./image/WechatIMG32.jpeg", "./image/WechatIMG33.jpeg"]
    }, {
        "id": 3,
        "title": "喜小瓶无糖气泡水",
        "content": "口味升级，专注纯粹果香；容量升级，加量不加价；设计升级，重塑全新流畅瓶型。清新果香唤醒味蕾，纤维添加，不止含糖",
        "price": "5.5",
        "img": ["./image/WechatIMG33.jpeg", "./image/WechatIMG33.jpeg"]
    }, {
        "id": 4,
        "title": "喜小瓶无糖气泡水",
        "content": "口味升级，专注纯粹果香；容量升级，加量不加价；设计升级，重塑全新流畅瓶型。清新果香唤醒味蕾，纤维添加，不止含糖",
        "price": "5.5",
        "img": ["./image/WechatIMG33.jpeg", "./image/WechatIMG33.jpeg"]
    }, {
        "id": 5,
        "title": "喜小瓶无糖气泡水",
        "content": "口味升级，专注纯粹果香；容量升级，加量不加价；设计升级，重塑全新流畅瓶型。清新果香唤醒味蕾，纤维添加，不止含糖",
        "price": "17.9",
        "img": ["./image/WechatIMG33.jpeg", "./image/WechatIMG33.jpeg"]
    }]

    for (i = 0; i < product.meuns.length; i++) {
        $("#v-pills-tab").append(
            '<a class="nav-link list-aX" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home">' + product.meuns[i] +
            '</a>')
    }

    for (i = 0; i < product.products.length; i++) {
        $("#v-pills-home").append('<div class="media"><span id="sumIndex" style="visibility:hidden">' + i +
            '</span><img src="' + product.products[i].img[0] +
            '" class="mr-3 media-img" alt="..."><div class="media-body" ><span id="sumIndex" style="visibility:hidden">' + i +
            '</span><h5 class="mt-0 font-weight-normal mediaX" id="titleAX" >' + product.products[i].title +
            '</h5><span class="media-font mediaX">' + product.products[i].content +
            '</span><div class="d-flex justify-content-between opt-btn"><h4 class="font-weight-normal">¥' + product.products[
                i].price + '</h4><span id="sumIndex" style="visibility:hidden">' + i +
            '</span><span style="visibility:hidden">abc</span><button class="btn btn-info btn-add">+</button></div></div></div>'
        );
    }
    //用户点开商品详情
    $(".mediaX").on("click", function () {
        $openModel = $(this).siblings().last();
        $("#toggleBody").css("display", "block");
        $obj = product.products[Number($(this).siblings(":first").text())];
        $("#imgX").children().remove();
        $("#contentToggle").children().remove();
        $imgName = $obj.img[0];
        $itemId = $obj.id;
        for (i = 0; i < $obj.img.length; i++) {
            if (i === 0) {
                $("#imgX").append('<div  class="carousel-item active"><img src="' + $obj.img[i] +
                    '" class="d-block w-100" alt="..."></div>');
            } else {
                $("#imgX").append('<div class="carousel-item"><img src="' + $obj.img[i] +
                    '" class="d-block w-100" alt="..."></div>');
            }
        }
        $("#contentToggle").append('<h3 id="toggleTitle">' + $obj.title + '</h3><p>产品描述</p><p id="toggleContent">' + $obj
            .content + '</p>');
        $("#priceToggle").html("¥" + $obj.price);

    })
    // 页面点击+1
    $(".btn-add").on("click", function () {
        $price = Number($(this).siblings(":first").text().split("¥")[1]);

        productX = product.products[Number($(this).siblings(":first").next().text())];

        let flag = true;
        for (let i = 0; i < product.outputinfo.length; i++) {
            if (product.outputinfo[i].id === productX.id) {
                product.outputinfo[i].num += 1;
                flag = false;
            }
        }
        if (flag) {
            var car = {};
            car.id = productX.id;
            car.img = productX.img[0];
            car.price = $price;
            car.title = productX.title;
            car.num = 1;
            // console.log(car);
            product.outputinfo.push(car);
        }

        product.totlePrice += $price;
        $("#totalPricr").text("总价：¥" + product.totlePrice.toFixed(2));
        // console.log($(this).prev().text());
        if (isNaN($(this).prev().text())) {
            // console.log(123);
            $(this).before('<button class="btn btn-info btn-desc">-</button><span id="sumOne">' + 1 + '</span>');
            // 这是左下角的数字
            $("#badgeX").text(Number($("#badgeX").text()) + 1);
            // pos
            $(".btn-desc").on("click", function () {
                productX = product.products[Number($(this).siblings(":first").next().text())];

                // console.log("productX:" + productX.id);

                $price = Number($(this).siblings(":first").text().split("¥")[1]);
                product.totlePrice -= $price;
                $("#totalPricr").text("总价：¥" + product.totlePrice.toFixed(2));
                // console.log(Number($(this).next().text()));
                $res = Number($(this).next().text()) - 1;
                $("#badgeX").text(Number($("#badgeX").text()) - 1);
                $(this).next().text($res);
                for (let i = 0; i < product.outputinfo.length; i++) {
                    if (product.outputinfo[i].id === productX.id) {
                        product.outputinfo[i].num -= 1;
                        if (product.outputinfo[i].num === 0) {
                            product.outputinfo.splice(i, 1);
                        }
                    }
                }
                if ($res < 1) {
                    $(this).next().remove();
                    $(this).remove();
                }
            });
        } else {
            $("#badgeX").text(Number($("#badgeX").text()) + 1)
            $(this).prev().text(Number($(this).prev().text()) + 1);
        }
    });
    // 点击减一


})
