package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jj implements s60 {
    public final ArrayList b;

    public jj(int i) {
        float fHeight;
        float fWidth;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        float f;
        switch (i) {
            case 1:
                this.b = new ArrayList(20);
                break;
            case 2:
            default:
                this.b = new ArrayList();
                break;
            case 3:
                this.b = new ArrayList();
                uv0 uv0VarA = xv0.d.a();
                if (uv0VarA.q() || uv0VarA.n()) {
                    for (f91 f91Var : uv0VarA.k()) {
                        if (f91Var.d().n()) {
                            ArrayList arrayList = this.b;
                            oa1 oa1Var = new oa1();
                            oa1Var.g = 0;
                            oa1Var.h = 0;
                            e91 e91VarE = f91Var.e();
                            Paint paint = new Paint(1);
                            oa1Var.c = paint;
                            paint.setColor(f91Var.d().b());
                            paint.setStrokeWidth(0.0f);
                            Paint.Style style = Paint.Style.FILL;
                            paint.setStyle(style);
                            Paint paint2 = new Paint(1);
                            oa1Var.d = paint2;
                            paint2.setColor(f91Var.d().c());
                            paint2.setStrokeWidth(f91Var.d().d());
                            paint2.setStyle(Paint.Style.STROKE);
                            Paint paint3 = new Paint(1);
                            oa1Var.e = paint3;
                            paint3.setStrokeWidth(0.0f);
                            paint3.setStyle(style);
                            paint3.setColor(f91Var.d().h());
                            db dbVarH = f91Var.h();
                            e91 e91Var = e91.top;
                            if (e91VarE == e91Var || e91VarE == e91.bottom) {
                                if (e91VarE == e91.bottom) {
                                    oa1Var.f = new Rect(dbVarH.d(), (dbVarH.c() + dbVarH.e()) - (f91Var.d().i() * 2), dbVarH.f() + dbVarH.d(), dbVarH.c() + dbVarH.e());
                                } else {
                                    oa1Var.f = new Rect(dbVarH.d(), dbVarH.e(), dbVarH.f() + dbVarH.d(), (f91Var.d().i() * 2) + dbVarH.e());
                                }
                                fHeight = (oa1Var.f.height() * 1.0f) / oa1Var.f.width();
                                fWidth = 1.0f;
                            } else {
                                if (e91VarE == e91.right) {
                                    f = 1.0f;
                                    oa1Var.f = new Rect((dbVarH.f() + dbVarH.d()) - (f91Var.d().i() * 2), dbVarH.e(), dbVarH.f() + dbVarH.d(), dbVarH.c() + dbVarH.e());
                                } else {
                                    f = 1.0f;
                                    oa1Var.f = new Rect(dbVarH.d(), dbVarH.e(), (f91Var.d().i() * 2) + dbVarH.d(), dbVarH.c() + dbVarH.e());
                                }
                                fWidth = (oa1Var.f.width() * f) / oa1Var.f.height();
                                fHeight = f;
                            }
                            Matrix matrix = new Matrix();
                            matrix.setScale(fWidth, fHeight, oa1Var.f.centerX(), oa1Var.f.centerY());
                            int i2 = na1.a[e91VarE.ordinal()];
                            if (i2 == 1) {
                                matrix.postTranslate((-oa1Var.f.width()) / 2.0f, 0.0f);
                            } else if (i2 == 2) {
                                matrix.postTranslate(oa1Var.f.width() / 2.0f, 0.0f);
                            } else if (i2 == 3) {
                                matrix.postTranslate(0.0f, (-oa1Var.f.height()) / 2.0f);
                            } else if (i2 == 4) {
                                matrix.postTranslate(0.0f, oa1Var.f.height() / 2.0f);
                            }
                            RadialGradient radialGradient = new RadialGradient(oa1Var.f.centerX(), oa1Var.f.centerY(), Math.max(oa1Var.f.width(), oa1Var.f.height()) / 2.0f, f91Var.d().h(), 0, Shader.TileMode.CLAMP);
                            radialGradient.setLocalMatrix(matrix);
                            paint3.setShader(radialGradient);
                            db dbVarH2 = f91Var.h();
                            da1 da1VarD = f91Var.d();
                            int iE = da1VarD.e();
                            boolean z = da1VarD.f() == ba1.outside;
                            oa1Var.b = new Path();
                            int iMax = Math.max(da1VarD.k(), dbVarH2.f());
                            int iMax2 = Math.max(da1VarD.k(), dbVarH2.c());
                            if (e91VarE == e91.left) {
                                int iD = dbVarH2.d() + Math.min(0, iMax - (da1VarD.j() + da1VarD.k())) + da1VarD.j();
                                oa1Var.g = dbVarH2.c() + dbVarH2.e();
                                Path path = oa1Var.b;
                                float f2 = iD;
                                float fE = dbVarH2.e();
                                float fK = da1VarD.k() + iD;
                                float f3 = oa1Var.g;
                                if (!z || iD > 0) {
                                    float f4 = iE;
                                    fArr4 = new float[]{f4, f4, f4, f4, f4, f4, f4, f4};
                                } else {
                                    float f5 = iE;
                                    fArr4 = new float[]{0.0f, 0.0f, f5, f5, f5, f5, 0.0f, 0.0f};
                                }
                                path.addRoundRect(f2, fE, fK, f3, fArr4, Path.Direction.CW);
                            } else if (e91VarE == e91.right) {
                                int iD2 = (dbVarH2.d() + (dbVarH2.f() - da1VarD.k())) - (Math.min(0, iMax - (da1VarD.j() + da1VarD.k())) + da1VarD.j());
                                oa1Var.g = dbVarH2.c() + dbVarH2.e();
                                Path path2 = oa1Var.b;
                                float f6 = iD2;
                                float fE2 = dbVarH2.e();
                                float fK2 = da1VarD.k() + iD2;
                                float f7 = oa1Var.g;
                                if (!z || da1VarD.k() + iD2 < ey0.c()) {
                                    float f8 = iE;
                                    fArr3 = new float[]{f8, f8, f8, f8, f8, f8, f8, f8};
                                } else {
                                    float f9 = iE;
                                    fArr3 = new float[]{f9, f9, 0.0f, 0.0f, 0.0f, 0.0f, f9, f9};
                                }
                                path2.addRoundRect(f6, fE2, fK2, f7, fArr3, Path.Direction.CW);
                            } else if (e91VarE == e91Var) {
                                int iE2 = dbVarH2.e() + Math.min(0, iMax2 - (da1VarD.j() + da1VarD.k())) + da1VarD.j();
                                oa1Var.g = da1VarD.k() + iE2;
                                Path path3 = oa1Var.b;
                                float fD = dbVarH2.d();
                                float f10 = iE2;
                                float f11 = dbVarH2.f() + dbVarH2.d();
                                float f12 = oa1Var.g;
                                if (!z || iE2 > 0) {
                                    float f13 = iE;
                                    fArr2 = new float[]{f13, f13, f13, f13, f13, f13, f13, f13};
                                } else {
                                    float f14 = iE;
                                    fArr2 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f14, f14, f14, f14};
                                }
                                path3.addRoundRect(fD, f10, f11, f12, fArr2, Path.Direction.CW);
                            } else if (e91VarE == e91.bottom) {
                                int iE3 = (dbVarH2.e() + (dbVarH2.c() - da1VarD.k())) - (Math.min(0, iMax2 - (da1VarD.j() + da1VarD.k())) + da1VarD.j());
                                oa1Var.g = da1VarD.k() + iE3;
                                Path path4 = oa1Var.b;
                                float fD2 = dbVarH2.d();
                                float f15 = iE3;
                                float f16 = dbVarH2.f() + dbVarH2.d();
                                float f17 = oa1Var.g;
                                if (!z || da1VarD.k() + iE3 < ey0.b()) {
                                    float f18 = iE;
                                    fArr = new float[]{f18, f18, f18, f18, f18, f18, f18, f18};
                                } else {
                                    float f19 = iE;
                                    fArr = new float[]{f19, f19, f19, f19, 0.0f, 0.0f, 0.0f, 0.0f};
                                }
                                path4.addRoundRect(fD2, f15, f16, f17, fArr, Path.Direction.CW);
                            }
                            oa1Var.h = 0;
                            arrayList.add(oa1Var);
                        } else if (f91Var.d().m()) {
                            this.b.add(new aa1(f91Var));
                        }
                    }
                }
                break;
        }
    }

    @Override // defpackage.s60
    public boolean a() {
        return false;
    }

    @Override // defpackage.s60
    public boolean c() {
        return false;
    }

    @Override // defpackage.s60
    public void draw(Canvas canvas) {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((ea1) obj).draw(canvas);
        }
    }

    public void f(String str, String str2) {
        ArrayList arrayList = this.b;
        arrayList.add(str);
        arrayList.add(str2.trim());
    }

    public void g(String str) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return;
            }
            if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                arrayList.remove(i);
                arrayList.remove(i);
                i -= 2;
            }
            i += 2;
        }
    }

    public void h(String str, String str2) {
        if (str.isEmpty()) {
            zy.n("name is empty");
        } else {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    Object[] objArr = {Integer.valueOf(cCharAt), Integer.valueOf(i), str};
                    byte[] bArr = be1.a;
                    zy.n(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", objArr));
                    break;
                }
            }
        }
        if (str2 != null) {
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    Object[] objArr2 = {Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2};
                    byte[] bArr2 = be1.a;
                    zy.n(String.format(Locale.US, "Unexpected char %#04x at %d in %s value: %s", objArr2));
                    break;
                }
            }
        } else {
            zy.r(l11.j("value for name ", str, " == null"));
        }
        g(str);
        f(str, str2);
    }

    public jj(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new fr0(jSONObjectOptJSONObject));
                }
            }
        }
        this.b = arrayList;
    }
}
