import com.baidu.www.mplus.bean.Employee;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;


/**
 * test
 */
public class TestCRUD {


    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    Employee employee = new Employee();

    private final static Logger logger = Logger.getLogger(TestCRUD.class);

    Gson gson = new Gson();

    /**
     * AR所有员工列表
     *
     * @throws SQLException
     */
    @Test
    public void activeRecordAll() throws SQLException {


        List<Employee> employeeList = employee.selectAll();

        if (!employeeList.isEmpty()) {
            logger.info("所有员工：" + gson.toJson(employeeList));
        }
    }


    /**
     * AR所有员工列表
     *
     * @throws SQLException
     */
    @Test
    public void activeRecordList() throws SQLException {


        List<Employee> employeeList = employee.selectList(new QueryWrapper<Employee>().eq("gender", "1"));

        if (!employeeList.isEmpty()) {
            logger.info("所有员工：" + gson.toJson(employeeList));
        }
    }

    /**
     * 查询一名员工
     *
     * @throws SQLException
     */
    @Test
    public void activeRecordOne() throws SQLException {

        Employee employee = new Employee();
        employee.setId(50);


        Employee employee1 = employee.selectById();

        if (employee1 != null) {
            logger.info("一个员工：" + gson.toJson(employee1));
        }
    }

    /**
     * 查询一名员工
     *
     * @throws SQLException
     */
    @Test
    public void activeRecordOne2() throws SQLException {


        Employee employee1 = employee.selectById(55);

        if (employee1 != null) {
            logger.info("一个员工：" + gson.toJson(employee1));
        }
    }


    /**
     * 统计查询
     *
     * @throws SQLException
     */
    @Test
    public void activeRecordCount() throws SQLException {


        Integer result = employee.selectCount(new QueryWrapper<Employee>().eq("gender", "1"));

        if (result != null || result > 0) {
            logger.info("一个员工：" + result);
        }
    }


    /**
     * AR添加用户
     *
     * @throws SQLException
     */
    @Test
    public void activeRecordAdd() throws SQLException {

        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee();

            employee.setLastName("Betty" + i);
            employee.setAge(12 + i);
            employee.setEmail("betty@163.com" + i);
            employee.setGender(1);

            boolean result = employee.insert();

            if (result == true) {
                logger.info("+++++++++++++++++添加成功+++++");
            }

            logger.info("获取主键值：" + employee.getId());
        }

    }


    /**
     * AR修改用户
     *
     * @throws SQLException
     */
    @Test
    public void activeRecordUpdate() throws SQLException {

        Employee employee = new Employee();
        employee.setId(60);
        employee.setAge(88);

        //根据ID修改
        boolean result = employee.updateById();

        employee.update(new QueryWrapper());

        if (result == true) {
            logger.info("++++++++++++++++修改成功+++++");
        }
    }


    /**
     * AR删除客户
     *
     * @throws SQLException
     */
    @Test
    public void activeRecordDeleted() throws SQLException {

        // 1.根据ID删除一个员工
        boolean result = employee.deleteById(59);

        if (result == true) {
            logger.info("++++++++++++++++删除成功+++++");
        }

    }


    /**
     * AR删除客户
     *
     * @throws SQLException
     */
    @Test
    public void activeRecordDeleted2() throws SQLException {

        employee.setId(57);

        // 1.根据ID删除一个员工
        boolean result = employee.deleteById();

        if (result == true) {
            logger.info("++++++++++++++++删除成功+++++");
        }

    }


    /**
     * AR分页查询
     *
     * @throws SQLException
     */
    @Test
    public void activeRecordPage() throws SQLException {

//        employee.setId(57);

        Employee employee2 = new Employee();

        IPage<Employee> employeePage =  employee2.selectPage(new Page<>(1,2),new QueryWrapper<Employee>().eq("gender", "1"));

        if (!employeePage.getRecords().isEmpty()) {
            List<Employee> employeeList = employeePage.getRecords();

            logger.info("所有员工：" + gson.toJson(employeeList));
        }

    }

}
