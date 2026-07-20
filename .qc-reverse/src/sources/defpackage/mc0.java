package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mc0 implements la0, ka0 {
    public final String a;
    public final int b;
    public final String c;
    public final ArrayList d = new ArrayList();

    public mc0(int i, String str, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    @Override // defpackage.ka0
    public final int a() {
        return this.b;
    }

    @Override // defpackage.la0
    public final int b() {
        return 2;
    }
}
