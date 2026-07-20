package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tn0 {
    public static final Logger a = Logger.getLogger(tn0.class.getName());

    public static sb a(Socket socket) throws IOException {
        if (socket == null) {
            zy.n("socket == null");
            return null;
        }
        if (socket.getOutputStream() == null) {
            zy.p("socket's output stream == null");
            return null;
        }
        z90 z90Var = new z90(1, socket);
        OutputStream outputStream = socket.getOutputStream();
        if (outputStream != null) {
            return new sb(z90Var, new sb(z90Var, outputStream));
        }
        zy.n("out == null");
        return null;
    }

    public static tb b(Socket socket) throws IOException {
        if (socket == null) {
            zy.n("socket == null");
            return null;
        }
        if (socket.getInputStream() == null) {
            zy.p("socket's input stream == null");
            return null;
        }
        z90 z90Var = new z90(1, socket);
        InputStream inputStream = socket.getInputStream();
        if (inputStream != null) {
            return new tb(z90Var, new tb(z90Var, inputStream));
        }
        zy.n("in == null");
        return null;
    }
}
