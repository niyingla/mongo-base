package com.mashibing.mongodb.enums;

import com.mashibing.mongodb.util.RandomUtil;
import org.junit.jupiter.api.Test;

/**
 * <p>随机生成中文姓名，性别，Email，手机号，住址</p>
 *
 * @author sunzhiqiang23
 * @date 2020-12-04 1:36
 */
public class NameAndPhone {
    private static String firstName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹苏潘葛范彭郎鲁韦昌马苗凤花方俞任袁柳鲍史唐费岑薛雷贺倪汤滕殷罗毕郝安常乐于时傅皮齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹米明臧戴谈宋庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万柯卢莫邓郁单杭洪包诸左石崔吉龚程裴陆荣翁荀羊於甄魏储段富巫乌焦巴弓山谷车侯蓬伊栾暴甘厉戎祖武符刘姜詹束龙叶黎白怀蒲台从卓党翟谭贡劳逄姬申濮牛燕尚农温别庄晏柴瞿阎充慕连茹习艾鱼容向古易慎戈廖庚终暨居衡步都耿满国寇广东殴殳沃利蔚越隆师巩聂晁勾敖融冷辛阚那简饶空曾沙乜养鞠须丰巢关相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连政濮孙端木巫马公良岳有琴梁丘门佟";
    private static String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
    private static String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";



    /**
     * 返回手机号码
     */
    private static String[] phoneFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    public static String getPhone() {
        int index = RandomUtil.getNum(0, phoneFirst.length - 1);
        String first = phoneFirst[index];
        String second = String.valueOf(RandomUtil.getNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(RandomUtil.getNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    /**
     * 返回中文姓名
     */
    private static String name_sex = "";

    public static String getChineseName() {
        int index = RandomUtil.getNum(0, firstName.length() - 1);
        String first = firstName.substring(index, index + 1);
        int sex = RandomUtil.getNum(0, 1);
        String str = boy;
        int length = boy.length();
        if (sex == 0) {
            str = girl;
            length = girl.length();
            name_sex = "女";
        } else {
            name_sex = "男";
        }
        index = RandomUtil.getNum(0, length - 1);
        String second = str.substring(index, index + 1);
        int hasThird = RandomUtil.getNum(0, 1);
        String third = "";
        if (hasThird == 1) {
            index = RandomUtil.getNum(0, length - 1);
            third = str.substring(index, index + 1);
        }
        return first + second + third;
    }


    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getChineseName());
            System.out.println(getPhone());
            System.out.println(getChineseName());
        }
    }
}