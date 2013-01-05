package hse.jack.setup;

import hse.jack.module.AccountModule;

import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * 
 * @author jack
 * 
 */
@IocBy(type = ComboIocProvider.class, args = {
		"*org.nutz.ioc.loader.json.JsonLoader", "ioc/",
		"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "hse.jack" })
@Encoding(input = "utf8", output = "utf8")
@Modules(value = AccountModule.class, scanPackage = true)
@Localization("msg")
@Ok("ioc:json")
@Fail("json")
@SetupBy(NutzSetup.class)
public class MainModule {
}
