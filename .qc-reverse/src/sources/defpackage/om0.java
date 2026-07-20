package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class om0 {
    public ViewParent a;
    public ViewParent b;
    public final ViewGroup c;
    public boolean d;
    public int[] e;

    public om0(ViewGroup viewGroup) {
        this.c = viewGroup;
    }

    public final boolean a(float f, float f2, boolean z) {
        ViewParent viewParentE;
        if (this.d && (viewParentE = e(0)) != null) {
            try {
                return viewParentE.onNestedFling(this.c, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedFling", e);
            }
        }
        return false;
    }

    public final boolean b(float f, float f2) {
        ViewParent viewParentE;
        if (this.d && (viewParentE = e(0)) != null) {
            try {
                return viewParentE.onNestedPreFling(this.c, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreFling", e);
            }
        }
        return false;
    }

    public final boolean c(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        ViewParent viewParentE;
        int i4;
        int i5;
        int[] iArr3;
        if (!this.d || (viewParentE = e(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr3 = this.e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (viewParentE instanceof pm0) {
            ((pm0) viewParentE).c(viewGroup, i, i2, iArr3, i3);
            viewGroup = viewGroup;
        } else if (i3 == 0) {
            try {
                viewParentE.onNestedPreScroll(viewGroup, i, i2, iArr3);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreScroll", e);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean d(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent viewParentE;
        int i6;
        int i7;
        int[] iArr3;
        if (this.d && (viewParentE = e(i5)) != null) {
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                ViewGroup viewGroup = this.c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i6 = iArr[0];
                    i7 = iArr[1];
                } else {
                    i6 = 0;
                    i7 = 0;
                }
                if (iArr2 == null) {
                    if (this.e == null) {
                        this.e = new int[2];
                    }
                    int[] iArr4 = this.e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (viewParentE instanceof qm0) {
                    ((qm0) viewParentE).d(viewGroup, i, i2, i3, i4, i5, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i3;
                    iArr3[1] = iArr3[1] + i4;
                    if (viewParentE instanceof pm0) {
                        ((pm0) viewParentE).e(viewGroup, i, i2, i3, i4, i5);
                    } else if (i5 == 0) {
                        try {
                            viewParentE.onNestedScroll(viewGroup, i, i2, i3, i4);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedScroll", e);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i6;
                    iArr[1] = iArr[1] - i7;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
        }
        return false;
    }

    public final ViewParent e(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i != 1) {
            return null;
        }
        return this.b;
    }

    public final boolean f(int i) {
        return e(i) != null;
    }

    public final boolean g(int i, int i2) {
        boolean zOnStartNestedScroll;
        if (!f(i2)) {
            if (this.d) {
                View view = this.c;
                View view2 = view;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z = parent instanceof pm0;
                    if (z) {
                        zOnStartNestedScroll = ((pm0) parent).f(view2, view, i, i2);
                    } else if (i2 == 0) {
                        try {
                            zOnStartNestedScroll = parent.onStartNestedScroll(view2, view, i);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                            zOnStartNestedScroll = false;
                        }
                    } else {
                        zOnStartNestedScroll = false;
                    }
                    if (zOnStartNestedScroll) {
                        if (i2 == 0) {
                            this.a = parent;
                        } else if (i2 == 1) {
                            this.b = parent;
                        }
                        if (z) {
                            ((pm0) parent).a(view2, view, i, i2);
                        } else if (i2 == 0) {
                            try {
                                parent.onNestedScrollAccepted(view2, view, i);
                            } catch (AbstractMethodError e2) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view2 = (View) parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void h(int i) {
        ViewParent viewParentE = e(i);
        if (viewParentE != null) {
            boolean z = viewParentE instanceof pm0;
            ViewGroup viewGroup = this.c;
            if (z) {
                ((pm0) viewParentE).b(viewGroup, i);
            } else if (i == 0) {
                try {
                    viewParentE.onStopNestedScroll(viewGroup);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (i == 0) {
                this.a = null;
            } else {
                if (i != 1) {
                    return;
                }
                this.b = null;
            }
        }
    }
}
