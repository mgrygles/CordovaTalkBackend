package org.cjug.presentations.cordova.cordova.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by freddy on 2/17/2018.
 */

@RestController
public class UserController {
    List<PhoneInfo> phones = populatePhones();
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void method(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "/swagger-ui.html");
    }


    @RequestMapping("/user/{userId}/balance")
    public @ResponseBody String getBalanceInfo(@PathVariable String userId) {
        return "100$";
    }

    @RequestMapping("/store/phones/{startFrom}/{endTo}")
    public @ResponseBody
    Collection<PhoneInfo> getPhones(@PathVariable int startFrom, @PathVariable int endTo) {

        return phones.subList(startFrom,endTo < phones.size() ? endTo : phones.size()-1);
    }

    private static List<PhoneInfo> populatePhones() {
        List<PhoneInfo> phones = new ArrayList<>();
        add(phones, "Iphone XXLarge", "One Million Dollars", "http://www.techxav.com/wp-content/uploads/2009/10/transparent-mobile-1.jpg");
        add(phones, "Galaxy Note 8", "930", "https://cdn57.androidauthority.net/wp-content/uploads/2017/08/Galaxy-Note-Review-15-Feature-840x472.jpg");
        add(phones, "Google Pixel 2", "649", "https://cdn57.androidauthority.net/wp-content/uploads/2017/10/google-pixel-2-and-2-xl-review-aa-9-of-19-840x472.jpg");
        add(phones, "LG V30","674.99","https://cdn57.androidauthority.net/wp-content/uploads/2017/10/LG-V30-Review-12-840x472.jpg");
        add(phones, "Galaxy S8","627.89","https://cdn57.androidauthority.net/wp-content/uploads/2017/04/samsung-galaxy-s8-review-aa-42-of-43-840x472.jpg");
        add(phones, "OnePlus 5T","559","https://cdn57.androidauthority.net/wp-content/uploads/2017/11/oneplus-5t-initial-review-aa-6-of-22-840x472.jpg");
        add(phones, "IPhone X","999","https://cdn.mos.cms.futurecdn.net/QLbu7SyAwQz64NXtJPmgKQ-650-80.jpg");
        add(phones, "IPhone 8 Plus","799","https://cdn.mos.cms.futurecdn.net/yzPdbKRFV8zrtK4XdXysqd-650-80.jpg");
        add(phones, "IPhone 8","699","https://cdn.mos.cms.futurecdn.net/7aca9mYE5CvPYj2MBBzKP9-650-80.jpg");
        add(phones, "IPhone 7 Plus","449","https://cdn.mos.cms.futurecdn.net/2169c727a45643fa6e5341a9a47ddc02-650-80.jpg");
        add(phones, "IPhone SE","159.99","https://cdn.mos.cms.futurecdn.net/c2c57d5d57ac8bd221fd9f0e750cccc8-650-80.jpg");



        return phones;

    }

    private static void add(List<PhoneInfo> phones, String name, String price, String image) {
        phones.add(new PhoneInfo(name, price, image));
    }
}
