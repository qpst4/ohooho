package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class eo implements co, fo {
    public final /* synthetic */ int b;
    public Object c;
    public int d;
    public int e;
    public Object f;
    public Cloneable g;

    public eo(eo eoVar) {
        this.b = 1;
        ClipData clipData = (ClipData) eoVar.c;
        clipData.getClass();
        this.c = clipData;
        int i = eoVar.d;
        if (i < 0) {
            Locale locale = Locale.US;
            zy.n("source is out of range of [0, 5] (too low)");
            throw null;
        }
        if (i > 5) {
            Locale locale2 = Locale.US;
            zy.n("source is out of range of [0, 5] (too high)");
            throw null;
        }
        this.d = i;
        int i2 = eoVar.e;
        if ((i2 & 1) == i2) {
            this.e = i2;
            this.f = (Uri) eoVar.f;
            this.g = (Bundle) eoVar.g;
            return;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
    }

    public void a(wi1 wi1Var, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ((((ci1) it.next()).a.c() & 8) != 0) {
                ((View) this.f).setTranslationY(s7.c(r3.a.b(), this.e, 0));
                return;
            }
        }
    }

    @Override // defpackage.co
    public go build() {
        return new go(new eo(this));
    }

    @Override // defpackage.fo
    public ClipData c() {
        return (ClipData) this.c;
    }

    @Override // defpackage.fo
    public int l() {
        return this.e;
    }

    @Override // defpackage.fo
    public ContentInfo m() {
        return null;
    }

    @Override // defpackage.co
    public void p(Uri uri) {
        this.f = uri;
    }

    @Override // defpackage.fo
    public int q() {
        return this.d;
    }

    @Override // defpackage.co
    public void setExtras(Bundle bundle) {
        this.g = bundle;
    }

    @Override // defpackage.co
    public void t(int i) {
        this.e = i;
    }

    public String toString() {
        String str;
        switch (this.b) {
            case 1:
                Uri uri = (Uri) this.f;
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(((ClipData) this.c).getDescription());
                sb.append(", source=");
                int i = this.d;
                sb.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i2 = this.e;
                sb.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return l11.k(sb, ((Bundle) this.g) != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public /* synthetic */ eo() {
        this.b = 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [int[], java.lang.Cloneable] */
    public eo(View view) {
        this.b = 2;
        this.g = new int[2];
        this.f = view;
    }
}
