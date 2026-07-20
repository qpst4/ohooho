package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bn0 {
    public Context a;
    public ArrayList b;
    public ArrayList c;
    public ArrayList d;
    public CharSequence e;
    public CharSequence f;
    public PendingIntent g;
    public int h;
    public boolean i;
    public i9 j;
    public boolean k;
    public Bundle l;
    public String m;
    public boolean n;
    public Notification o;
    public ArrayList p;

    public static CharSequence a(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final void b(i9 i9Var) {
        if (this.j != i9Var) {
            this.j = i9Var;
            if (((bn0) i9Var.c) != this) {
                i9Var.c = this;
                b(i9Var);
            }
        }
    }
}
