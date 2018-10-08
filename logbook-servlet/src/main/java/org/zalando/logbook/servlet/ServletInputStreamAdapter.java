package org.zalando.logbook.servlet;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.io.InputStream;

final class ServletInputStreamAdapter extends ServletInputStream {

    private final ServletInputStream original;
    private final InputStream stream;

    public ServletInputStreamAdapter(final ServletInputStream original, final InputStream stream) {
        this.original = original;
        this.stream = stream;
    }

    @Override
    public int read() throws IOException {
        return stream.read();
    }

    @Override
    public int read(final byte[] b) throws IOException {
        return stream.read(b);
    }

    @Override
    public int read(final byte[] b, final int off, final int len) throws IOException {
        return stream.read(b, off, len);
    }

    @Override
    public boolean isFinished() {
        return original.isFinished();
    }

    @Override
    public boolean isReady() {
        return original.isReady();
    }

    @Override
    public void setReadListener(final ReadListener listener) {
        this.original.setReadListener(listener);
    }

}
