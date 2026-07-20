package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class p20 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ p20(String str, Context context, Object obj, int i, int i2) {
        this.a = i2;
        this.b = str;
        this.c = context;
        this.e = obj;
        this.d = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.a;
        int i2 = this.d;
        Object obj = this.e;
        Context context = this.c;
        String str = this.b;
        switch (i) {
            case 0:
                Object[] objArr = {(m20) obj};
                ArrayList arrayList = new ArrayList(1);
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                arrayList.add(obj2);
                return s20.b(str, context, Collections.unmodifiableList(arrayList), i2);
            default:
                try {
                    return s20.b(str, context, (ArrayList) obj, i2);
                } catch (Throwable unused) {
                    return new r20(-3);
                }
        }
    }
}
