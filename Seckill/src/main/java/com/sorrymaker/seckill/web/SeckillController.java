package com.sorrymaker.seckill.web;

import com.sorrymaker.seckill.dto.Exposer;
import com.sorrymaker.seckill.dto.SeckillExecution;
import com.sorrymaker.seckill.dto.SeckillResult;
import com.sorrymaker.seckill.entity.Seckill;
import com.sorrymaker.seckill.enums.SeckillStatEnum;
import com.sorrymaker.seckill.exception.RepeatKillException;
import com.sorrymaker.seckill.exception.SeckillCloseException;
import com.sorrymaker.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author nextGame
 * @Date 2021/8/8 16:32
 * @Version 1.0
 */
@Controller
@RequestMapping("/seckill") //url： /模块/资源/{id}/细分/seckill/list
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        //获取列表页
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        //list.jsp+model = ModelAndView
        return "list";
    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redirect:seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    //ajax接口，返回类型json
    @ResponseBody //这个注解告诉spring，把返回类型封装成json。
    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})//json里面乱码问题可以得到解决。
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
        SeckillResult<Exposer> seckillResult;

        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);

            seckillResult = new SeckillResult<Exposer>(true, exposer);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            seckillResult = new SeckillResult<Exposer>(false, e.getMessage());
        }

        return seckillResult;
    }

    @ResponseBody
    @RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
                                                  @PathVariable("md5") String md5,
                                                  @CookieValue(value = "killPhone", required = false) Long phone) {

        if (phone == null) {
            return new SeckillResult<SeckillExecution>(false, "未注册");
        }
        try {
            SeckillExecution execution = seckillService.executeSeckill(seckillId, phone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (RepeatKillException e1) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (SeckillCloseException e2) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(true, execution);
        }
    }

    @RequestMapping(value="/time/now" , method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time(){
        Date now = new Date();
        return new SeckillResult<Long>(true,now.getTime());
    }

}
