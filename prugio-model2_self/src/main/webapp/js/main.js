const header = $("#header.pattern01");
const gnb = $("#gnb");
const gnbList = $("#gnb .gnbList");
const gnbListItem = $("#gnb .gnbList > li");
// 하나씩 나오게....

//자식 찾을때  2가지  
//  뭐뭐.find(자손요소)       css에서 공백으로 찾는거 즉 자손까지 찾는거
//  뭐뭐.children(자식요소)   css에서 >으로 찾는거 즉 자식만 찾는거
//  뭐뭐.siblings()          뭐뭐의 이웃들 찾는거
//  뭐뭐.parent()            뭐뭐의 한단계 위로
//  뭐뭐.parents(해당되는 요소)           뭐뭐의 위쪽 부모 전부다


//full down 
/*
    depth02의 display를 block프로 잡는다.
    header의 높이를 적당히 잡고 overflow:hidden처리해서 아래쪽 요소들을 가려둔다.
*/
gnbListItem.on("mouseenter",function(){
    const _this = $(this);
    const depth02 = _this.find(".depth02");
    header.addClass("on");
    //depth02.stop().slideDown(300);
    //depth02.show();
    //console.log(_this.parents("#gnb"));
});
gnbListItem.on("mouseleave",function(){
    const _this = $(this);
    const depth02 = _this.find(".depth02");
    header.removeClass("on");
    //depth02.stop().slideUp(300);
    //depth02.show();
    //console.log(_this.parents("#gnb"));
});

// 하나씩 부드럽게 나오게 하기
//depth02를 display:none처리를 해두고 slideDown() 또는 Up()을 사용한다. 이때 반드시 stop()을 붙여서 기존에 queue에 남아 있는
//에니메이션을 초기화 하고 사용한다.
/*
gnbListItem.on("mouseenter",function(){
    const _this = $(this);
    const depth02 = _this.find(".depth02");
    depth02.stop().slideDown(300);
    //depth02.show();
    //console.log(_this.parents("#gnb"));
});
gnbListItem.on("mouseleave",function(){
    const _this = $(this);
    const depth02 = _this.find(".depth02");
    //header.removeClass("on");
    depth02.stop().slideUp(300);
    //depth02.show();
    //console.log(_this.parents("#gnb"));
});
*/


const mainVisualSlider = new Swiper("#mainVisual",{
    effect:"fade",
    loop:true,
    pagination:{
        el:"#mainVisual .pagination",
        clickable:true
    },
    navigation:{
        prevEl:"#mainVisual .prev",
        nextEl:"#mainVisual .next",
    }
})

const noticeItem = $("#notice li a");
noticeItem.on("click",function(){
    const _this = $(this);
    _this.next().stop().slideToggle();
    _this.parent().siblings().find(".answer").stop().slideUp();
    return false;
});


/*
const faqItem = $(".faq li a");
faqItem.on("click",function(){
    const _this = $(this);
    _this.next().stop().slideToggle();
    _this.parent().siblings().find(".answer").stop().slideUp();
    return false;
})
*/