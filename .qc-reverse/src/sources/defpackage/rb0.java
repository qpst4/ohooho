package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rb0 implements sb0 {
    public final InputContentInfo b;

    public rb0(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.b = new InputContentInfo(uri, clipDescription, uri2);
    }

    @Override // defpackage.sb0
    public final ClipDescription a() {
        return this.b.getDescription();
    }

    @Override // defpackage.sb0
    public final Object e() {
        return this.b;
    }

    @Override // defpackage.sb0
    public final Uri f() {
        return this.b.getContentUri();
    }

    @Override // defpackage.sb0
    public final void g() {
        this.b.requestPermission();
    }

    @Override // defpackage.sb0
    public final Uri h() {
        return this.b.getLinkUri();
    }

    public rb0(Object obj) {
        this.b = (InputContentInfo) obj;
    }
}
