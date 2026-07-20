package defpackage;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class p10 {
    public final String a;
    public final HashMap b = new HashMap();

    public p10(String str) {
        this.a = str;
    }

    public final File a(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int iIndexOf = encodedPath.indexOf(47, 1);
        if (iIndexOf == -1) {
            zy.h("Unable to find path from root: ", uri);
            return null;
        }
        String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
        String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
        File file = (File) this.b.get(strDecode);
        if (file == null) {
            zy.h("Unable to find configured root for ", uri);
            return null;
        }
        File file2 = new File(file, strDecode2);
        try {
            File canonicalFile = file2.getCanonicalFile();
            if (q10.a(canonicalFile.getPath()).startsWith(q10.a(file.getPath()).concat("/"))) {
                return canonicalFile;
            }
            throw new SecurityException("Resolved path jumped beyond configured root");
        } catch (IOException unused) {
            zy.h("Failed to resolve canonical path for ", file2);
            return null;
        }
    }
}
