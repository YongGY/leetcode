//
///**
// * https://leetcode.com/discuss/interview-question/125204/Design-Connection-Pool./
// *
// * http://www.360doc.com/content/15/1209/11/19017656_519051049.shtml
// *
// * https://throwsnew.com/2017/06/12/commons-pool/
// *
// * 连接池的设计思路
// * 维护一空闲连接池，初始为空，需要连接时建立，用完的连接回收进入空闲连接池；
// * 后续所需连接从空闲连接池获取；activeNum记录活跃连接数目；
// * 当空闲连接池为空且活跃连接数达到上限时，请求等待，超时即获取连接失败，超时前有连接被释放方可获得连接
// * 数据库连接管理类，单例模式
// * 可以管理加载多个数据库驱动，维护多个数据库连接池
// */
//
//public class DBConnectionManager {
//    private static DBConnectionManager dbm = null;
//
//    // 单例模式里的成员变量都相当于是static了？
//
//	// 客户数目
//    private static int clients = 0;
//
//    // 加载的驱动器集合
//    private Set<Driver> drivers = new HashSet<Driver>();
//
//    // 数据库连接池字典
//
//    private Hashtable<String,DBConnectionPool> pools = new Hashtable<String,DBConnectionPool>();
//
//    private final Logger log = Logger.getInstance(DBConnectionPool.class);
//
//    private DBConnectionManager() {
//        loadDrivers();
//        createPools();
//    }
//
//    /**
//     * 装载和注册所有的JDBC驱动程序
//     */
//    private void loadDrivers() {    }
//
//    /**
//     * 根据配置文件创建数据库连接池
//     */
//    private void createPools() {   }
//
//    /**
//     * 获得单例
//     */
//    public synchronized static DBConnectionManager getInstance() {    }
//
//
//    /**
//     * 从指定连接池中获取可用连接，无等待
//     * @param poolName  要获取连接的连接池名称
//     * @return  连接池中的一个可用连接或null
//     */
//
//    public Connection getConnection(String poolName) {  }
//
//    /**
//     * 从指定的连接池获取可用连接，有等待超时
//     * @param poolName  要获取连接的连接池名称
//     * @param timeout   获取可用连接的超时时间,单位为秒
//     * @return          连接池中的一个可用连接或null
//     */
//    public Connection getConnection(String poolName,long timeout) {  }
//
//    /**
//     * 回收指定连接池的连接
//     * @param poolName  连接池名称
//     * @param conn      要回收的连接
//     */
//    public void freeConnection(String poolName,Connection conn) {   }
//
//    /**
//     * 关闭所有连接，撤销驱动器的注册
//     */
//    public synchronized void release() {    }
//
//
//
//
//
//
//
//
//
//    /**
//     * 此内部类定义了一个连接池.
//     * 它能够获取数据库连接,直到预定的最 大连接数为止
//     * 在返回连接给客户程序之前,它能够验证连接的有效性
//     */
//    private class DBConnectionPool {
//
//        /**
//         * @param maxConn   设定的连接池允许的最大连接数
//         * @param url       数据库连接url
//         * @param poolName  连接池名称
//         * @param user      数据库用户名，或null
//         * @param pwd       数据库用户密码，或null
//         */
//        public DBConnectionPool(int maxConn, String url, String poolName, String user , String pwd) {  }
//
//        /**
//         * 获得一个可用连接，不保证任何情况都能返回一个连接（比如超过最大连接数的时候返回null）
//         * 1、若空闲连接池不为空，从空闲连接池取出一个连接后检查有效性，正常则返回，失效则重新获取连接
//         * 2、若空闲连接池为空且未超过最大连接数限制，新建一个连接并返回
//         * 3、空闲连接数为空且超过最大连接数限制，返回null
//         * @return  获得的可用连接
//         */
//        public synchronized Connection getConnection() {     }
//
//        /**
//         * 当无空闲连接而又未达到最大连接数限制时创建新的连接
//         * @return  新创建的连接
//         */
//        private Connection newConnection() {    }
//
//        /**
//         * 获得一个可用连接，超过最大连接数时线程等待，直到有有连接释放时返回一个可用连接或者超时返回null
//         * @param timeout 等待连接的超时时间，单位为秒
//         */
//        public synchronized Connection getConnection(long timeout) {    }
//
//        /**
//         * 将释放的空闲连接加入空闲连接池，活跃连接数减一并激活等待连接的线程
//         * @param conn  释放的连接
//         */
//        public synchronized void freeConnection(Connection conn) {   }
//
//        /**
//         * 关闭空闲连接池中的所有连接
//         */
//
//        public synchronized void releaseAll() {    }
//
//}
//
//
//