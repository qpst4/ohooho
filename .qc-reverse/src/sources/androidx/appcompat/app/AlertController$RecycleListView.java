package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import defpackage.zs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {
    public final int b;
    public final int c;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zs0.t);
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
