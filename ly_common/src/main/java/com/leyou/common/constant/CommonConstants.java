package com.leyou.common.constant;

public class CommonConstants {
    public final static String RESOURCE_TYPE_MENU = "MENU";
    public final static String RESOURCE_TYPE_BTN = "BUTTON";
    public final static String RESOURCE_TYPE_FUNCTION = "FUNCTION";
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40101;
    public static final Integer EX_USER_PASS_INVALID_CODE = 40001;
    public static final Integer EX_USER_LOCKED_CODE = 40102; //用户被锁定
    public static final Integer EX_VERIFICATION_CODE = 40002;//用户验证码错误
    public static final Integer EX_GET_VERIFICATION_CODE = 40003;//提示获取验证码
    public static final Integer EX_WECHATT_USER_SCAN_CODE = 40004;//提示扫码用户绑定微信
    // 客户端token异常
    public static final Integer EX_CLIENT_INVALID_CODE = 40301;
    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    // 移动端token异常
    public static final Integer EX_MOBILE_INVALID_CODE = 40201;
    // 无效的优惠券
    public static final Integer EX_COUPON_INVALID_CODE = 10000;
    public static final String EX_COUPON_INVALID_MSG = "无效的优惠券";
    public static final Integer EX_COUPON_LIMIT_CODE = 10001;
    public static final String EX_COUPON_LIMIT_MSG = "已达优惠券获取限额";
    //hotel token异常
    public static final Integer EX_HOTEL_INVALID_CODE = 40401;
    public static final Integer EX_HOTEL_FORBIDDEN_CODE = 40402;
    // 支付中状态
    public static final Integer PAYMENT_PENDING = 201;

    public static final Integer SUCCESS_CODE = 200;
    public static final Integer EX_OTHER_CODE = 500;

    // 参数异常
    public static final Integer EX_PARAM_CODE = 501;

    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";
    public static final String CONTEXT_KEY_USER_NAME = "currentUser";
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";
    public static final String TRACE_ID = "traceId";
    public static final String TRACE_ID_COLON = "traceId:";

    public static final String HOTEL_ROOM_ID = "roomId";
    public static final String HOTEL_HOTEL_ID = "hotelId";
    public static final String HOTEL_BRANCH_ID = "branchId";

    public static final String PENDING = "PENDING";
    public static final String CANCELLED = "CANCELLED";
    public static final String CONFIRMED = "CONFIRMED";
    public static final String COMPLETED = "COMPLETED";
    public static final String ADMIN = "admin";
    public static final String CLIENT = "client";
    public static final String WECHAT = "wechat";
    public static final String CASHIER = "cashier";

    // 机器状态
    public static final String USING = "USING"; // 机器使用中
    public static final String RESERVING = "RESERVING"; // 机器预定中
    public static final String FREE = "FREE"; // 机器空闲中
    public static final String FAULT = "FAULT"; // 故障机器

    // Coupon Rules
    public static final String ADD_MEMBER = "ADD_MEMBER";
    public static final String RECOMMENDATION = "RECOMMENDATION";

    public static final String PUBWIN_MESSAGE_TYPE_PARAM = "pubwinMessageType";

    public static final String PUBWIN_NOTIFY_EXCHANGE = "pubwin.notify.exchange";

    public static final String PUBWIN_NOTIFY_LOGIN = "pubwin.notify.login";
    public static final String PUBWIN_NOTIFY_TEMP_ACTIVE = "pubwin.notify.temp.active";
    public static final String PUBWIN_NOTIFY_MEMBER_ACTIVE = "pubwin.notify.member.active";
    public static final String PUBWIN_NOTIFY_TEMP_CHECKIN = "pubwin.notify.member.checkin";
    public static final String PUBWIN_NOTIFY_MEMBER_CHECKIN = "pubwin.notify.member.checkin";
    public static final String PUBWIN_NOTIFY_TEMP_CHECKOUT = "pubwin.notify.member.checkout";
    public static final String PUBWIN_NOTIFY_MEMBER_CHECKOUT = "pubwin.notify.member.checkout";
    public static final String PUBWIN_NOTIFY_CONSUME = "pubwin.notify.consume";
    public static final String PUBWIN_NOTIFY_CHANGE_MACHINE = "pubwin.notify.change.machine";
    public static final String PUBWIN_NOTIFY_SHIFT = "pubwin.notify.shift";
    public static final String SOKETIO_NOTIFICATION = "socketio.notification";
    public static final String PRODUCT_SALES_STATISTICS = "product.sales.statistics";

    public static final String BRANCH_KEY_PREFIX = "branch_";
    public static final String SOCKETIO_BRANCH_KEY_PREFIX = "socketio_branch_";
    public static final String ONLINE_NUMBER_KEY_PREFIX = "online_number_";
    public static final String SOCKETIO_ONLINE_NUMBER_KEY_PREFIX = "socketio_online_number_";
    public static final String COLON_SEPARATOR = ":";
    public static final String HTTP_PREFIX = "http://";
    public static final String NOT_FOUND_SERVICE_MSG = "not found related service for this branch: ";

    public static final String TRANSFER_ORDER_ID = "0"; // 转账订单号

    public static final String CONSUME_TYPE_ADD_TOTAL = "1"; // 加钱
    public static final String CONSUME_TYPE_SUB_TOTAL = "2"; // 减钱
    public static final String CONSUME_TYPE_MEMBER_WITHDRAW_BALANCE = "3"; // 会员提现本金

    public static final String CONSUME_TYPE_ADD_DEPOSIT = "11"; // 增加押金
    public static final String CONSUME_TYPE_SUB_DEPOSIT = "12"; // 扣除押金
    public static final String CONSUME_TYPE_CHECKOUT_DEPOSIT = "13"; // 临时卡找零

    public static final String CONSUME_TYPE_ADD_AWARD = "21"; // 增加奖励
    public static final String CONSUME_TYPE_SUB_AWARD = "22"; // 扣除奖励
    public static final String CONSUME_TYPE_MEMBER_WITHDRAW_AWARD = "23"; // 会员提现赠送

    public static final String CONSUME_TYPE_TRANSFER_IN = "31";
    public static final String CONSUME_TYPE_TRANSFER_OUT = "32";

    public static final String CONSUME_TYPE_USE_COUPON = "41"; // 使用优惠券 增加奖励
    public static final String CONSUME_TYPE_CANCEL_COUPON = "42"; // 取消优惠券 扣除奖励

    public static final String CONSUME_TYPE_SPECIAL_FREE = "51"; // 特免 增加奖励
    public static final String CONSUME_TYPE_CANCEL_SPECIAL_FREE = "52"; // 取消特免 扣除奖励

    public static final String NOT_FOUND_SERVICE_FOR_SID_MSG = "not found related service for this sid: ";
    public static final String PUBWIN_ONLINE_BRANCH_KEY_PREFIX = "pubwin_online_branch_";
    public static final String SOCKETIO_ONLINE_BRANCH_KEY_PREFIX = "socketio_online_branch_";
    public static final String PURCHASE_TYPE_PURCHASES = "PURCHASES"; // 仓库类型 进货
    public static final String PURCHASE_TYPE_RETURNS = "RETURNS"; // 仓库类型 退货

    public static final String PAY_BRAND_CONFIG = "BRAND_CONFIG"; // 品牌支付配置
    public static final String PAY_BRANCH_CONFIG = "BRANCH_CONFIG"; // 门店支付配置

    public static final String WECHAT_BINGING_LOGIN_VALIDATE_CODE = "wechatBingingLoginValidateCode:";

    public static final String ES_HOTEL_SMS_BIND_CODE = "ES_HOTEL_SMS_BIND_CODE:"; // 电竞酒店绑定手机号验证码

    public static final String ES_HOTEL_ROOM_BOOKING_ORDER = "ES_HOTEL_ROOM_BOOKING_ORDER:"; // 酒店预定订单

    public static final String ES_HOTEL_MEMBER_LEVEL_ORDER = "ES_HOTEL_MEMBER_LEVEL_ORDER:"; // 会员订单

    public static final String ES_HOTEL_MEMBER_RECHARGE_ORDER = "ES_HOTEL_MEMBER_RECHARGE_ORDER:"; // 会员余额充值订单



    public static final String ES_HOTEL_ROOM_ORDER_GUID_PREFIX = "sdx_guid_"; // 房间订单业务ID

    // redis锁前缀
    public final static String LOCK = "LOCK:";

    // 活动用户ID导入
    public final static String ACTIVITY_INFO_CARD_ID_IMPORT = "ACTIVITY_INFO_CARD_ID_IMPORT:";

    /**
     * 分隔符
     */
    public static interface delimiter {

        /**
         * 逗号
         */
        final String COMMA = ",";
    }

    // 学习强国对接
    // 新增会员通知第三方
    public final static String ADD_MEMBER_NOTIFY = "http://learn.ybwhgroup.com:8888/learn/user/";
    // 新增门店通知第三方
    public final static String ADD_BASE_BRANCH_NOTIFY = "http://learn.ybwhgroup.com:8888/learn/branch/";
    /**
     * 用户状态code
     */
    public static interface AccountStatus {
        final String LOCKED="LOCKED";
        final String ACTIVATED="ACTIVATED";
    }

    public static final String AGENCY_ROLE_RESOURCE = "AGENCY_ROLE_RESOURCE_";

    //角色资源
    public static final String ROLE_APP_TYPE = "ROLE_RESOURCE:";
    //品牌资源
    public static final String BRAND_APP_TYPE = "BRAND_RESOURCE:";

    // 会员操作记录
    // 添加会员
    //    public static final String ADD = "ADD";
    // 修改会员
    public static final String UPDATE_MEMBER = "UPDATE_MEMBER";
    // 激活会员
    public static final String ACTIVE = "ACTIVE";
    // 会员上机
    public static final String CHECK_IN = "CHECK_IN";
    // 会员充值
    public static final String RECHARGE = "RECHARGE";
    // 会员转账
    public static final String TRANSFER = "TRANSFER";
    // 会员下机
    public static final String CHECK_OUT = "CHECK_OUT";

    public static final String NOW_MAKE_DRINKS = "NOW_MAKE_DRINKS";

    public static interface allProductType{

        //全部商品
        final Integer ALL = 0;
        //部分商品
        final Integer PART = 1;
    }

    // 无证件号订单
    public static final String NO_CARD_ORDERS = "NO_CARD_ORDERS";
    
    public static final String BOOKING_NOTIFY_YZ = "hotel.notify.booking";
    
    public static final String CANCEL_BOOKING_NOTIFY_YZ = "hotel.notify.cancel.booking";
    
    public static final int BOOKING_NOTIFY_YZ_TYPE = 1;
    
    public static final int CANCEL_BOOKING_NOTIFY_YZ_TYPE = 2;

    // 门店运营状态
    // 营业中（连锁版）
    public static final int OPENING_CHAIN_VERSION = 0;
    // 营业中（单机版）
    public static final int OPENING_STANDALONE_VERSION = 1;
    // 待营业
    public static final int WAITING_FOR_OPENING = 2;
    // 测试门店
    public static final int TEST_BRANCH = 3;
    // 退盟门店
    public static final int QUIT_JOINING_BRANCH = 4;
    // 预订座位来源
    public static final String BOOKING_FROM = "SDX_WECHAT";
    // 预订座位订单状态
    // 待上机 0
    public static final int BOOKING_PENGDING = 0;
    // 已完成 1
    public static final int BOOKING_COMPLETED = 1;
    // 已取消 2
    public static final int BOOKING_CANCELLED = 2;
    // 已过期 3
    public static final int BOOKING_OVERDUED = 3;

    // 延时队列基础配置 暂时都使用同一个配置 后期写到配置里
    public static final String COMMON_DELAY_QUEUE = "common.delay.queue";
    public static final String COMMON_DELAY_EXCHANGE = "common.delay.exchange";
    public static final String COMMON_DELAY_ROUTING_KEY = "common_delay";
    public static final String COMMON_QUEUE_NAME = "common.queue";
    public static final String BOOKING_ROUTING_KEY = "booking";
    public static final String DELAYED_TYPE = "direct";
    public static final String DELAYED_MESSAGE = "delayed-message";

    /**
     * 延迟队列 TTL 名称
     */
    public static final String RESERVE_DELAY_QUEUE = "reserve.delay.queue";

    /**
     * DLX，dead letter发送到的 exchange
     * 延时消息就是发送到该交换机的
     */
    public static final String RESERVE_DELAY_EXCHANGE = "reserve.delay.exchange";

    /**
     * routing key 名称
     * 具体消息发送在该 routingKey 的
     */
    public static final String RESERVE_DELAY_ROUTING_KEY = "reserve_delay";

    // 需要监听的
    public static final String RESERVE_QUEUE_NAME = "reserve.queue";
    // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称
    public static final String RESERVE_EXCHANGE_NAME = "reserve.exchange";

    // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称
    // 使用时具体业务需要具体定义
    // 预订座位的routing_key
    public static final String RESERVE_ROUTING_KEY = "reserve";

    /**
     * @Fields  : 活动信息 Redis前缀key
     * @author qiaomengnan
     */
    public static final String ACTIVITY_INFO = "ACTIVITY_INFO";

    // 是否已抽奖
    // 是
    public static final Integer LOTTERY_NUMBER_USED = 1;
    // 否
    public static final Integer LOTTERY_NUMBER_NO_USED = 0;
    // 订单取消
    public static final Integer LOTTERY_NUMBER_CANCELLED = 2;

    // 批量插入条数限制
    public static final Integer BATCH_INSERT_LIMIT = 1000;

    // 充值兑换码是否使用
    // 是
    public static final Integer CD_KEY_USED = 1;
    // 否
    public static final Integer CD_KEY_NO_USED = 0;

    /**
     * ***********************************************************
     * 电子巡场本延迟队列 start
     * ***********************************************************
     */
    public static final String TOUR_DELAY_QUEUE = "tour.delay.queue";
    public static final String TOUR_DELAY_EXCHANGE = "tour.delay.exchange";
    public static final String TOUR_ROUTING_KEY = "tour";

    /**
     * 补充身份证号任务的redis key前缀
     */
    public static final String REDIS_SAVE_CARD_ID = "SAVE_CARD_ID:";

    // 会员等级
    public final static String DEFAULT_LEVEL = "普通会员";

    // 门店是否加密
    // 加密
    public static final Integer ENCRYPTION = 0;
    // 未加密
    public static final Integer UNENCRYPTED = 1;
    /**
    * @Description:  查询类型
    * @Date: 2020/4/23
    */
    // 0 七天 1 30天 2 季度 3 年度
    public static final Integer NUMBER_OF_WEEKS = 0;
    public static final Integer NUMBER_OF_MONTH = 1;
    public static final Integer NUMBER_OF_QUARTER = 2;
    public static final Integer NUMBER_OF_YEAR = 3;
    
    public static final String PURCHASE_NOTIFY_KEY = "purchase.notify";

    // 采购业务类型 采购
    public static final String PURCHASE = "PURCHASE";
}
