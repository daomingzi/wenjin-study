//package com.wenjin.algorithm.test;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonValue;
//
//import java.util.Arrays;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
///**
// * Created by sunguanjie on 18-7-18.
// */
//public enum ProductEnum {
//    FuLuKangRui(10),
//    FuShouLianLian(11),
//    ZhuoYueZhiZhen(12),
//    FuShouLianLian_N(13),
//    ShengShiWenYing(14),
//    CaiFuAnYing(16),
//    LeXiangWuYou(17),
//    FuLuKangYi(18),
//    XingWuYouLiangQuan(19),
//    ZongHeYiWai(20),
//    FuLuBeiYou(21),
//    RongYaoHuLi(22),
//    RongYaoXinNao(23),
//    ZhenAiJianKang2019Hospital(24),
//    ZhenAiJianKang2019Surgery(25),
//    YueXiangJingCai(26),
//    YaoShiJinSheng(27),
//    ShengShiJinCai(28),
//    RongYaoYiWai(29),
//    ChengZhangWuYou(30),
//    FuLuJiaBei(31),
//    QuanWuYou(32),
//    RongYaoYiLiaoShareMain(33),
//    KangYuYiLiao(34),
//    ShouHuTianShi(35),
//    YueXiangWuYou(36),
//    ZhuoYueYiSheng(37),
//    ZhenAiDingShou(38),
//    ZhuangYuanShu(39),
//    YueXiangJinSheng(40),
//    AiWuYouMain(41),
//    KangYueYiLiaoMain(43),
//    ZhuoYueHuaZhang(44),
//    FuLuLifeLongZhongJi(45),
//    CaiFuZhiYing(46),
//    ZhuoYueJinZun(47),
//    EBaiFen(48),
//    ZhuoYueYouXuan(49),
//    FuLuShuangJia(50),
//    BaiWanXingWuYou(51),
//    FuDuoDuo(52),
//    JiXiangRenSheng(53),
//    JiDuoDuo(54),
//    CaiFuManMan(55),
//    GuoXiYiHao(56),
//    DaWanQu(57),
//    FuLuShunXi(58),
//    AiAnXin(59),
//    XinRuYi(60),
//    FuLuXinXi(61),
//    SixChuanJiaBao(62),
//    ZhenAiJianKang2021(63),
//    FuLu20LiangQuan(64),
//    DaWanQu2021(65),
//    YiAnXin(66),
//    ChaoAnXin(67),
//    ChaoEBao2021(68),
//    YaoWuYou2021(69),
//    ZhuoYueYiXiang(70),
//    FuJiaFuLuTeDingJiBing(999),
//    FuJiaJiaBeiZhongJi(1000);
//
//    private int mainInsuranceId;
//
//    ProductEnum(int i) {
//        this.mainInsuranceId = i;
//    }
//
//    @JsonValue
//    public int getMainInsuranceId() {
//        return mainInsuranceId;
//    }
//
//    public Long getLongValue() {
//        return Long.valueOf(mainInsuranceId);
//    }
//
//    @JsonCreator
//    public static ProductEnum fromValue(int i) {
//
//        return codeMap.get(i);
//    }
//
//    public static ProductEnum fromLongValue(Long i) {
//        if (i != null) return codeMap.get(i.intValue());
//        else return null;
//    }
//
//    private static final Map<Integer, ProductEnum> codeMap = Arrays.stream(ProductEnum.values()).collect(Collectors.toMap
//            (ProductEnum::getMainInsuranceId, Function.identity()));
//
//
//}
