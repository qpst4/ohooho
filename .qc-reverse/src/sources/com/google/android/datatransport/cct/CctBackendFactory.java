package com.google.android.datatransport.cct;

import android.content.Context;
import defpackage.c91;
import defpackage.rp;
import defpackage.wc;
import defpackage.xi;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CctBackendFactory {
    public c91 create(rp rpVar) {
        Context context = ((wc) rpVar).a;
        wc wcVar = (wc) rpVar;
        return new xi(context, wcVar.b, wcVar.c);
    }
}
