package org.jboss.jdf.ticketmonster.test.utils;

import org.jboss.arquillian.core.spi.LoadableExtension;

public class ArquillianExtension implements LoadableExtension {

    @Override
    public void register(ExtensionBuilder builder) {
//        builder.observer(ScreenshotTaker.class);
//        builder.observer(PrepareBrowserSession.class);
    }

}
