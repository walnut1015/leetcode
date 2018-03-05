package Other;

import java.net.URL;

/**
 * Created by Tanya on 2017/9/18.
 */
public class LoadClass
{
    public void load()
    {
        System.out.println(LoadClass.class.getResource("/").getPath());
        System.out.println(this.getClass().getResource("/").getPath());
        URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }

    }
}
