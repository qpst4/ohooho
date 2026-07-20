package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rn {
    public static final SparseIntArray j;
    public int a;
    public int b;
    public int c;
    public float d;
    public float e;
    public float f;
    public int g;
    public String h;
    public int i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.append(3, 1);
        sparseIntArray.append(5, 2);
        sparseIntArray.append(9, 3);
        sparseIntArray.append(2, 4);
        sparseIntArray.append(1, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(4, 7);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(7, 9);
        sparseIntArray.append(6, 10);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rs0.f);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (j.get(index)) {
                case 1:
                    this.e = typedArrayObtainStyledAttributes.getFloat(index, this.e);
                    break;
                case 2:
                    this.c = typedArrayObtainStyledAttributes.getInt(index, this.c);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                    } else {
                        String str = yb0.d[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                    }
                    break;
                case 4:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.a = un.f(typedArrayObtainStyledAttributes, index, this.a);
                    break;
                case 6:
                    this.b = typedArrayObtainStyledAttributes.getInteger(index, this.b);
                    break;
                case 7:
                    this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
                    break;
                case 8:
                    this.g = typedArrayObtainStyledAttributes.getInteger(index, this.g);
                    break;
                case 9:
                    this.f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                    break;
                case 10:
                    int i2 = typedArrayObtainStyledAttributes.peekValue(index).type;
                    if (i2 == 1) {
                        this.i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    } else if (i2 == 3) {
                        String string = typedArrayObtainStyledAttributes.getString(index);
                        this.h = string;
                        if (string.indexOf("/") > 0) {
                            this.i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        }
                    } else {
                        typedArrayObtainStyledAttributes.getInteger(index, this.i);
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
