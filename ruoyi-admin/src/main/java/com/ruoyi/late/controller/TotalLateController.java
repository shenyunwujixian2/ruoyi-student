package com.ruoyi.late.controller;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.late.domain.UserLate;
import com.ruoyi.late.service.IUserLateService;
import com.ruoyi.record.service.impl.SysRecordWaringServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 学生晚归迟到记录Controller
 * 
 * @author 小阿福
 * @date 2021-03-24
 */

@Api(tags="3.1、统计晚归数量")
@RestController
@RequestMapping("/late/totallate")
public class TotalLateController extends BaseController
{
    @Autowired
    private IUserLateService userLateService;

    @Autowired
    private TokenService tokenService;
    /**
     *
     */
    @ApiOperation("昨日统计晚归数量")
//    @PreAuthorize("@ss.hasPermi('late:totallate:top')")
    @GetMapping("/top")
    public AjaxResult top()
    {
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        String teachId = "";
        String dwdm = "";
        if(!roleIds.equals(100L)){
            teachId = loginUser.getUsername()+"";
        }
        if(roleIds.equals(110L)){
            teachId = "";
            dwdm = loginUser.getUser().getRemark()+"";
        }
        //昨天
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,-1);
        String dayTime = sdf.format(calendar.getTime());
//        String dayTime = DateUtils.getDate();

        //  回寝室状态 0未归 1已归  2晚归
        List<HashMap> returnList = new ArrayList<>();
        String num1 = getNum(dayTime,"2", teachId, dwdm);
        String num2 = getNum(dayTime,"0", teachId, dwdm);
        //黄牌警告
        HashMap<String, Object> searchYellowWaring = new HashMap<>();
        searchYellowWaring.put("getYellowWaring", 1);
        searchYellowWaring.put("teachId", teachId);
        searchYellowWaring.put("dwdm", dwdm);
        searchYellowWaring.put("startshowTime", dayTime);
        searchYellowWaring.put("endshowTime", dayTime);
        String yellowNum = getWaringCount(searchYellowWaring);
        String num3 = yellowNum;
        //红牌 警告
        HashMap<String, Object> searchRedWaring = new HashMap<>();
        searchRedWaring.put("getRedWaring", 1);
        searchRedWaring.put("teachId", teachId);
        searchRedWaring.put("dwdm", dwdm);
        searchRedWaring.put("startshowTime", dayTime);
        searchRedWaring.put("endshowTime", dayTime);
        String  redNum = getWaringCount(searchRedWaring);
        String num4 = redNum;

        HashMap<String,Object> returnMap1 = setReturnMap("晚归人数", num1);
        HashMap<String,Object> returnMap2 = setReturnMap("未回寝人数", num2);
        HashMap<String,Object> returnMap3 = setReturnMap("红牌警告", num3);
        HashMap<String,Object> returnMap4 = setReturnMap("严重警告", num4);

        returnList.add(returnMap1);
        returnList.add(returnMap2);
        returnList.add(returnMap3);
        returnList.add(returnMap4);
        return AjaxResult.success(returnList);
    }

    /**
     *  首页获取数量
     * @param showTime
     * @param lateStatus
     * @param teachId
     * @param dwdm
     * @return
     */
    private String getNum(String showTime,String lateStatus,String teachId,String dwdm){
        String num  ="0";
        HashMap<String,Object> searchMap = new HashMap<>();
        searchMap.put("showTime", showTime);
        searchMap.put("lateStatus", lateStatus);
        searchMap.put("teachId", teachId);
        searchMap.put("dwdm", dwdm);
        Map<String,Object> returnMap = userLateService.getCountByHashMap(searchMap);
        if(returnMap!=null){
            num = returnMap.get("num").toString();
        }
        return num;
    }
    @Autowired
    SysRecordWaringServiceImpl sysRecordWaringServiceImpl;
    //获取警告人数
    private String getWaringCount(HashMap<String, Object> searchMap){
        PageHelper.startPage(1, 1, "");
        List<Map<String, Object>> mListWaring = sysRecordWaringServiceImpl.getCount(searchMap);
//        long total = new PageInfo(mListWaring).getTotal();
//        return total+"";
        String yNum ="0";
        if(mListWaring.size()>0){
            Map<String,Object> yMap = mListWaring.get(0);
            yNum = yMap.get("allNum").toString();
        }
        return yNum;
    }


    /**
     * 设置返回数据
     * @param typeName
     * @param num
     * @return
     */
    private HashMap<String,Object> setReturnMap(String typeName, String num){
        HashMap<String,Object> returnMap = new HashMap<>();
        returnMap.put("typeName",typeName);
        returnMap.put("num",num);
        return returnMap;
    }

    /**
     * 未处理待办列表
     */
    @ApiOperation("未处理待办列表")
//    @PreAuthorize("@ss.hasPermi('late:late:list')")
    @GetMapping("/teachlist")
    public TableDataInfo teachlist(UserLate userLate)
    {
        HashMap<String,Object> searchMap = new HashMap<>();
        searchMap.put("teachStatus", -1);
        searchMap.put("showTime", DateUtils.getBeforeDateStr());
        searchMap.put("groupByFieldName", "teach_id");
        //获取用户权限 增加查询列表
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long roleIds = loginUser.getUser().getDeptId();
        String teachId = "";
        if(!roleIds.equals(100L)){
            teachId = loginUser.getUsername()+"";
        }
        String dwdm = "";
        if(roleIds.equals(110L)){
            teachId = "";
            dwdm = loginUser.getUser().getRemark()+"";
        }
        searchMap.put("teachId", teachId);
        searchMap.put("dwdm", dwdm);
//        searchMap.put("userId", SecurityUtils.getLoginUser().getUser().getUserId().toString());
        startPage();
        List<Map<String,Object>> list = userLateService.getList(searchMap);
        return getDataTable(list);
    }


}
