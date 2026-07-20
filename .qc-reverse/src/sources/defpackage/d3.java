package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class d3 extends ir {
    public final int h0;
    public final Map i0;

    public d3(int i, Map map) {
        this.h0 = i;
        this.i0 = map;
    }

    @Override // defpackage.gq0, defpackage.j30
    public void J(Bundle bundle) {
        super.J(bundle);
        lq0 lq0Var = this.Z;
        lq0Var.f = "temp";
        lq0Var.c = null;
        lq0Var.b().edit().clear().commit();
        Context contextU = u();
        int i = this.h0;
        lq0.d(contextU, i);
        Map map = this.i0;
        if (map != null) {
            SharedPreferences.Editor editorEdit = this.Z.b().edit();
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    editorEdit.putString((String) entry.getKey(), (String) value);
                } else if (value instanceof Boolean) {
                    editorEdit.putBoolean((String) entry.getKey(), ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    editorEdit.putFloat((String) entry.getKey(), ((Float) value).floatValue());
                } else if (value instanceof Long) {
                    editorEdit.putLong((String) entry.getKey(), ((Long) value).longValue());
                } else if (value instanceof Integer) {
                    editorEdit.putInt((String) entry.getKey(), ((Integer) value).intValue());
                } else if (value instanceof Double) {
                    editorEdit.putInt((String) entry.getKey(), ((Double) value).intValue());
                }
            }
            editorEdit.commit();
        }
        k0(null, i);
    }

    @Override // defpackage.gq0
    public final void i0(String str, Bundle bundle) {
    }
}
