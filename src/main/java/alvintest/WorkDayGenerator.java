package alvintest;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by Alvin on 2014/6/17 0017.
 */
public class WorkDayGenerator {

//    insert into T_WORK_DAY (id, cur_date, week, is_work_day) values (137, to_date('16-10-2013', 'dd-mm-yyyy'), '4', '1');
//    insert into T_WORK_DAY (id, cur_date, week, is_work_day) values (138, to_date('17-10-2013', 'dd-mm-yyyy'), '5', '1');
//    insert into T_WORK_DAY (id, cur_date, week, is_work_day) values (139, to_date('18-10-2013', 'dd-mm-yyyy'), '6', '1');
//    insert into T_WORK_DAY (id, cur_date, week, is_work_day) values (140, to_date('19-10-2013', 'dd-mm-yyyy'), '7', '0');
//    insert into T_WORK_DAY (id, cur_date, week, is_work_day) values (141, to_date('20-10-2013', 'dd-mm-yyyy'), '1', '0');

    private static int START_NO = 304;//开始主键
    private static int DAY_OF_NUM = 300;//天数

    public static void main(String[] args) {
        //当前时间戳
        DateTime dt = new DateTime("2014-04-01");

        MutableDateTime mdt = new MutableDateTime(dt);
        StringBuilder sbSQL = new StringBuilder();
        for (int i = 0; i < DAY_OF_NUM; i++) {
            sbSQL.append("insert into T_WORK_DAY (id, cur_date, week, is_work_day) values (")
                    .append(START_NO + i)
                    .append(", to_date('")
                    .append(mdt.toString(DateTimeFormat.forPattern("dd-MM-yyyy")))
                    .append("', 'dd-mm-yyyy'), '")
                    .append((mdt.getDayOfWeek() + 1 == 8) ? 1 : mdt.getDayOfWeek() + 1)
                    .append("', '")
                    .append((mdt.getDayOfWeek() == 6 || mdt.getDayOfWeek() == 7) ? "0" : "1")
                    .append("');\n");
            mdt.addDays(1);
        }
        System.out.println(sbSQL.toString());
    }
}
