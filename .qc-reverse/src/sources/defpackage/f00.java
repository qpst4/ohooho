package defpackage;

import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f00 {
    public static final byte[] A;
    public static final byte[] B;
    public static final byte[] C;
    public static final byte[] D;
    public static final byte[] E;
    public static final byte[] F;
    public static final byte[] G;
    public static final byte[] H;
    public static final byte[] I;
    public static final byte[] J;
    public static final byte[] K;
    public static final byte[] L;
    public static final byte[] M;
    public static final byte[] N;
    public static final byte[] O;
    public static final String[] P;
    public static final int[] Q;
    public static final byte[] R;
    public static final c00 S;
    public static final c00[][] T;
    public static final c00[] U;
    public static final HashMap[] V;
    public static final HashMap[] W;
    public static final HashSet X;
    public static final HashMap Y;
    public static final Charset Z;
    public static final byte[] a0;
    public static final byte[] b0;
    public static final Pattern c0;
    public static final Pattern d0;
    public static final Pattern e0;
    public static final boolean t = Log.isLoggable("ExifInterface", 3);
    public static final int[] u;
    public static final int[] v;
    public static final byte[] w;
    public static final byte[] x;
    public static final byte[] y;
    public static final byte[] z;
    public String a;
    public FileDescriptor b;
    public AssetManager.AssetInputStream c;
    public int d;
    public final HashMap[] e;
    public final HashSet f;
    public ByteOrder g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public byte[] m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        u = new int[]{8, 8, 8};
        v = new int[]{8};
        w = new byte[]{-1, -40, -1};
        x = new byte[]{102, 116, 121, 112};
        y = new byte[]{109, 105, 102, 49};
        z = new byte[]{104, 101, 105, 99};
        A = new byte[]{79, 76, 89, 77, 80, 0};
        B = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        C = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        D = new byte[]{101, 88, 73, 102};
        E = new byte[]{73, 72, 68, 82};
        F = new byte[]{73, 69, 78, 68};
        G = new byte[]{82, 73, 70, 70};
        H = new byte[]{87, 69, 66, 80};
        I = new byte[]{69, 88, 73, 70};
        J = new byte[]{-99, 1, 42};
        K = "VP8X".getBytes(Charset.defaultCharset());
        L = "VP8L".getBytes(Charset.defaultCharset());
        M = "VP8 ".getBytes(Charset.defaultCharset());
        N = "ANIM".getBytes(Charset.defaultCharset());
        O = "ANMF".getBytes(Charset.defaultCharset());
        P = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        Q = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        R = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        c00[] c00VarArr = {new c00(254, 4, "NewSubfileType"), new c00(255, 4, "SubfileType"), new c00("ImageWidth", 256, 3, 4), new c00("ImageLength", 257, 3, 4), new c00(258, 3, "BitsPerSample"), new c00(259, 3, "Compression"), new c00(262, 3, "PhotometricInterpretation"), new c00(270, 2, "ImageDescription"), new c00(271, 2, "Make"), new c00(272, 2, "Model"), new c00("StripOffsets", 273, 3, 4), new c00(274, 3, "Orientation"), new c00(277, 3, "SamplesPerPixel"), new c00("RowsPerStrip", 278, 3, 4), new c00("StripByteCounts", 279, 3, 4), new c00(282, 5, "XResolution"), new c00(283, 5, "YResolution"), new c00(284, 3, "PlanarConfiguration"), new c00(296, 3, "ResolutionUnit"), new c00(301, 3, "TransferFunction"), new c00(305, 2, "Software"), new c00(306, 2, "DateTime"), new c00(315, 2, "Artist"), new c00(318, 5, "WhitePoint"), new c00(319, 5, "PrimaryChromaticities"), new c00(330, 4, "SubIFDPointer"), new c00(513, 4, "JPEGInterchangeFormat"), new c00(514, 4, "JPEGInterchangeFormatLength"), new c00(529, 5, "YCbCrCoefficients"), new c00(530, 3, "YCbCrSubSampling"), new c00(531, 3, "YCbCrPositioning"), new c00(532, 5, "ReferenceBlackWhite"), new c00(33432, 2, "Copyright"), new c00(34665, 4, "ExifIFDPointer"), new c00(34853, 4, "GPSInfoIFDPointer"), new c00(4, 4, "SensorTopBorder"), new c00(5, 4, "SensorLeftBorder"), new c00(6, 4, "SensorBottomBorder"), new c00(7, 4, "SensorRightBorder"), new c00(23, 3, "ISO"), new c00(46, 7, "JpgFromRaw"), new c00(700, 1, "Xmp")};
        c00[] c00VarArr2 = {new c00(33434, 5, "ExposureTime"), new c00(33437, 5, "FNumber"), new c00(34850, 3, "ExposureProgram"), new c00(34852, 2, "SpectralSensitivity"), new c00(34855, 3, "PhotographicSensitivity"), new c00(34856, 7, "OECF"), new c00(34864, 3, "SensitivityType"), new c00(34865, 4, "StandardOutputSensitivity"), new c00(34866, 4, "RecommendedExposureIndex"), new c00(34867, 4, "ISOSpeed"), new c00(34868, 4, "ISOSpeedLatitudeyyy"), new c00(34869, 4, "ISOSpeedLatitudezzz"), new c00(36864, 2, "ExifVersion"), new c00(36867, 2, "DateTimeOriginal"), new c00(36868, 2, "DateTimeDigitized"), new c00(36880, 2, "OffsetTime"), new c00(36881, 2, "OffsetTimeOriginal"), new c00(36882, 2, "OffsetTimeDigitized"), new c00(37121, 7, "ComponentsConfiguration"), new c00(37122, 5, "CompressedBitsPerPixel"), new c00(37377, 10, "ShutterSpeedValue"), new c00(37378, 5, "ApertureValue"), new c00(37379, 10, "BrightnessValue"), new c00(37380, 10, "ExposureBiasValue"), new c00(37381, 5, "MaxApertureValue"), new c00(37382, 5, "SubjectDistance"), new c00(37383, 3, "MeteringMode"), new c00(37384, 3, "LightSource"), new c00(37385, 3, "Flash"), new c00(37386, 5, "FocalLength"), new c00(37396, 3, "SubjectArea"), new c00(37500, 7, "MakerNote"), new c00(37510, 7, "UserComment"), new c00(37520, 2, "SubSecTime"), new c00(37521, 2, "SubSecTimeOriginal"), new c00(37522, 2, "SubSecTimeDigitized"), new c00(40960, 7, "FlashpixVersion"), new c00(40961, 3, "ColorSpace"), new c00("PixelXDimension", 40962, 3, 4), new c00("PixelYDimension", 40963, 3, 4), new c00(40964, 2, "RelatedSoundFile"), new c00(40965, 4, "InteroperabilityIFDPointer"), new c00(41483, 5, "FlashEnergy"), new c00(41484, 7, "SpatialFrequencyResponse"), new c00(41486, 5, "FocalPlaneXResolution"), new c00(41487, 5, "FocalPlaneYResolution"), new c00(41488, 3, "FocalPlaneResolutionUnit"), new c00(41492, 3, "SubjectLocation"), new c00(41493, 5, "ExposureIndex"), new c00(41495, 3, "SensingMethod"), new c00(41728, 7, "FileSource"), new c00(41729, 7, "SceneType"), new c00(41730, 7, "CFAPattern"), new c00(41985, 3, "CustomRendered"), new c00(41986, 3, "ExposureMode"), new c00(41987, 3, "WhiteBalance"), new c00(41988, 5, "DigitalZoomRatio"), new c00(41989, 3, "FocalLengthIn35mmFilm"), new c00(41990, 3, "SceneCaptureType"), new c00(41991, 3, "GainControl"), new c00(41992, 3, "Contrast"), new c00(41993, 3, "Saturation"), new c00(41994, 3, "Sharpness"), new c00(41995, 7, "DeviceSettingDescription"), new c00(41996, 3, "SubjectDistanceRange"), new c00(42016, 2, "ImageUniqueID"), new c00(42032, 2, "CameraOwnerName"), new c00(42033, 2, "BodySerialNumber"), new c00(42034, 5, "LensSpecification"), new c00(42035, 2, "LensMake"), new c00(42036, 2, "LensModel"), new c00(42240, 5, "Gamma"), new c00(50706, 1, "DNGVersion"), new c00("DefaultCropSize", 50720, 3, 4)};
        c00[] c00VarArr3 = {new c00(0, 1, "GPSVersionID"), new c00(1, 2, "GPSLatitudeRef"), new c00("GPSLatitude", 2, 5, 10), new c00(3, 2, "GPSLongitudeRef"), new c00("GPSLongitude", 4, 5, 10), new c00(5, 1, "GPSAltitudeRef"), new c00(6, 5, "GPSAltitude"), new c00(7, 5, "GPSTimeStamp"), new c00(8, 2, "GPSSatellites"), new c00(9, 2, "GPSStatus"), new c00(10, 2, "GPSMeasureMode"), new c00(11, 5, "GPSDOP"), new c00(12, 2, "GPSSpeedRef"), new c00(13, 5, "GPSSpeed"), new c00(14, 2, "GPSTrackRef"), new c00(15, 5, "GPSTrack"), new c00(16, 2, "GPSImgDirectionRef"), new c00(17, 5, "GPSImgDirection"), new c00(18, 2, "GPSMapDatum"), new c00(19, 2, "GPSDestLatitudeRef"), new c00(20, 5, "GPSDestLatitude"), new c00(21, 2, "GPSDestLongitudeRef"), new c00(22, 5, "GPSDestLongitude"), new c00(23, 2, "GPSDestBearingRef"), new c00(24, 5, "GPSDestBearing"), new c00(25, 2, "GPSDestDistanceRef"), new c00(26, 5, "GPSDestDistance"), new c00(27, 7, "GPSProcessingMethod"), new c00(28, 7, "GPSAreaInformation"), new c00(29, 2, "GPSDateStamp"), new c00(30, 3, "GPSDifferential"), new c00(31, 5, "GPSHPositioningError")};
        c00[] c00VarArr4 = {new c00(1, 2, "InteroperabilityIndex")};
        c00[] c00VarArr5 = {new c00(254, 4, "NewSubfileType"), new c00(255, 4, "SubfileType"), new c00("ThumbnailImageWidth", 256, 3, 4), new c00("ThumbnailImageLength", 257, 3, 4), new c00(258, 3, "BitsPerSample"), new c00(259, 3, "Compression"), new c00(262, 3, "PhotometricInterpretation"), new c00(270, 2, "ImageDescription"), new c00(271, 2, "Make"), new c00(272, 2, "Model"), new c00("StripOffsets", 273, 3, 4), new c00(274, 3, "ThumbnailOrientation"), new c00(277, 3, "SamplesPerPixel"), new c00("RowsPerStrip", 278, 3, 4), new c00("StripByteCounts", 279, 3, 4), new c00(282, 5, "XResolution"), new c00(283, 5, "YResolution"), new c00(284, 3, "PlanarConfiguration"), new c00(296, 3, "ResolutionUnit"), new c00(301, 3, "TransferFunction"), new c00(305, 2, "Software"), new c00(306, 2, "DateTime"), new c00(315, 2, "Artist"), new c00(318, 5, "WhitePoint"), new c00(319, 5, "PrimaryChromaticities"), new c00(330, 4, "SubIFDPointer"), new c00(513, 4, "JPEGInterchangeFormat"), new c00(514, 4, "JPEGInterchangeFormatLength"), new c00(529, 5, "YCbCrCoefficients"), new c00(530, 3, "YCbCrSubSampling"), new c00(531, 3, "YCbCrPositioning"), new c00(532, 5, "ReferenceBlackWhite"), new c00(33432, 2, "Copyright"), new c00(34665, 4, "ExifIFDPointer"), new c00(34853, 4, "GPSInfoIFDPointer"), new c00(50706, 1, "DNGVersion"), new c00("DefaultCropSize", 50720, 3, 4)};
        S = new c00(273, 3, "StripOffsets");
        T = new c00[][]{c00VarArr, c00VarArr2, c00VarArr3, c00VarArr4, c00VarArr5, c00VarArr, new c00[]{new c00(256, 7, "ThumbnailImage"), new c00(8224, 4, "CameraSettingsIFDPointer"), new c00(8256, 4, "ImageProcessingIFDPointer")}, new c00[]{new c00(257, 4, "PreviewImageStart"), new c00(258, 4, "PreviewImageLength")}, new c00[]{new c00(4371, 3, "AspectFrame")}, new c00[]{new c00(55, 3, "ColorSpace")}};
        U = new c00[]{new c00(330, 4, "SubIFDPointer"), new c00(34665, 4, "ExifIFDPointer"), new c00(34853, 4, "GPSInfoIFDPointer"), new c00(40965, 4, "InteroperabilityIFDPointer"), new c00(8224, 1, "CameraSettingsIFDPointer"), new c00(8256, 1, "ImageProcessingIFDPointer")};
        V = new HashMap[10];
        W = new HashMap[10];
        X = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        Y = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        Z = charsetForName;
        a0 = "Exif\u0000\u0000".getBytes(charsetForName);
        b0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            c00[][] c00VarArr6 = T;
            if (i >= c00VarArr6.length) {
                HashMap map = Y;
                c00[] c00VarArr7 = U;
                map.put(Integer.valueOf(c00VarArr7[0].a), 5);
                map.put(Integer.valueOf(c00VarArr7[1].a), 1);
                map.put(Integer.valueOf(c00VarArr7[2].a), 2);
                map.put(Integer.valueOf(c00VarArr7[3].a), 3);
                map.put(Integer.valueOf(c00VarArr7[4].a), 7);
                map.put(Integer.valueOf(c00VarArr7[5].a), 8);
                Pattern.compile(".*[1-9].*");
                c0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                d0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                e0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            V[i] = new HashMap();
            W[i] = new HashMap();
            for (c00 c00Var : c00VarArr6[i]) {
                V[i].put(Integer.valueOf(c00Var.a), c00Var);
                W[i].put(c00Var.b, c00Var);
            }
            i++;
        }
    }

    public f00(InputStream inputStream) throws IOException {
        c00[][] c00VarArr = T;
        this.e = new HashMap[c00VarArr.length];
        this.f = new HashSet(c00VarArr.length);
        this.g = ByteOrder.BIG_ENDIAN;
        this.a = null;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.c = (AssetManager.AssetInputStream) inputStream;
            this.b = null;
        } else if (inputStream instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream) inputStream;
            try {
                g00.c(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                this.c = null;
                this.b = fileInputStream.getFD();
            } catch (Exception unused) {
                if (t) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
                this.c = null;
                this.b = null;
            }
        } else {
            this.c = null;
            this.b = null;
        }
        r(inputStream);
    }

    public static Pair n(String str) {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair pairN = n(strArrSplit[0]);
            if (((Integer) pairN.first).intValue() == 2) {
                return pairN;
            }
            for (int i = 1; i < strArrSplit.length; i++) {
                Pair pairN2 = n(strArrSplit[i]);
                int iIntValue = (((Integer) pairN2.first).equals(pairN.first) || ((Integer) pairN2.second).equals(pairN.first)) ? ((Integer) pairN.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairN.second).intValue() == -1 || !(((Integer) pairN2.first).equals(pairN.second) || ((Integer) pairN2.second).equals(pairN.second))) ? -1 : ((Integer) pairN.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair(2, -1);
                }
                if (iIntValue == -1) {
                    pairN = new Pair(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairN = new Pair(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairN;
        }
        if (!str.contains("/")) {
            try {
                try {
                    long j = Long.parseLong(str);
                    return (j < 0 || j > 65535) ? j < 0 ? new Pair(9, -1) : new Pair(4, -1) : new Pair(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair(12, -1);
            }
        }
        String[] strArrSplit2 = str.split("/", -1);
        if (strArrSplit2.length == 2) {
            try {
                long j2 = (long) Double.parseDouble(strArrSplit2[0]);
                long j3 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j2 >= 0 && j3 >= 0) {
                    if (j2 <= 2147483647L && j3 <= 2147483647L) {
                        return new Pair(10, 5);
                    }
                    return new Pair(5, -1);
                }
                return new Pair(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair(2, -1);
    }

    public static ByteOrder u(zz zzVar) throws IOException {
        short s = zzVar.readShort();
        boolean z2 = t;
        if (s == 18761) {
            if (z2) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s != 19789) {
            zy.o("Invalid byte order: ", Integer.toHexString(s));
            return null;
        }
        if (z2) {
            Log.d("ExifInterface", "readExifSegment: Byte Align MM");
        }
        return ByteOrder.BIG_ENDIAN;
    }

    public final void A(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws IOException {
        if (t) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        zz zzVar = new zz(bufferedInputStream);
        a00 a00Var = new a00(bufferedOutputStream, ByteOrder.BIG_ENDIAN);
        if (zzVar.readByte() != -1) {
            zy.p("Invalid marker");
            return;
        }
        a00Var.a(-1);
        if (zzVar.readByte() != -40) {
            zy.p("Invalid marker");
            return;
        }
        a00Var.a(-40);
        String strB = b("Xmp");
        HashMap[] mapArr = this.e;
        b00 b00Var = (strB == null || !this.s) ? null : (b00) mapArr[0].remove("Xmp");
        a00Var.a(-1);
        a00Var.a(-31);
        I(a00Var);
        if (b00Var != null) {
            mapArr[0].put("Xmp", b00Var);
        }
        byte[] bArr = new byte[4096];
        while (zzVar.readByte() == -1) {
            byte b = zzVar.readByte();
            if (b == -39 || b == -38) {
                a00Var.a(-1);
                a00Var.a(b);
                lc1.m(zzVar, a00Var);
                return;
            }
            if (b != -31) {
                a00Var.a(-1);
                a00Var.a(b);
                int unsignedShort = zzVar.readUnsignedShort();
                a00Var.m(unsignedShort);
                int i = unsignedShort - 2;
                if (i < 0) {
                    zy.p("Invalid length");
                    return;
                }
                while (i > 0) {
                    int i2 = zzVar.read(bArr, 0, Math.min(i, 4096));
                    if (i2 >= 0) {
                        a00Var.write(bArr, 0, i2);
                        i -= i2;
                    }
                }
            } else {
                int unsignedShort2 = zzVar.readUnsignedShort();
                int i3 = unsignedShort2 - 2;
                if (i3 < 0) {
                    zy.p("Invalid length");
                    return;
                }
                byte[] bArr2 = new byte[6];
                if (i3 >= 6) {
                    zzVar.readFully(bArr2);
                    if (Arrays.equals(bArr2, a0)) {
                        zzVar.a(unsignedShort2 - 8);
                    }
                }
                a00Var.a(-1);
                a00Var.a(b);
                a00Var.m(unsignedShort2);
                if (i3 >= 6) {
                    i3 = unsignedShort2 - 8;
                    a00Var.write(bArr2);
                }
                while (i3 > 0) {
                    int i4 = zzVar.read(bArr, 0, Math.min(i3, 4096));
                    if (i4 >= 0) {
                        a00Var.write(bArr, 0, i4);
                        i3 -= i4;
                    }
                }
            }
        }
        zy.p("Invalid marker");
    }

    public final void B(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws Throwable {
        if (t) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        zz zzVar = new zz(bufferedInputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        a00 a00Var = new a00(bufferedOutputStream, byteOrder);
        lc1.l(zzVar, a00Var, C.length);
        if (this.o == 0) {
            int i = zzVar.readInt();
            a00Var.g(i);
            lc1.l(zzVar, a00Var, i + 8);
        } else {
            lc1.l(zzVar, a00Var, (r2 - r7.length) - 8);
            zzVar.a(zzVar.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                a00 a00Var2 = new a00(byteArrayOutputStream2, byteOrder);
                I(a00Var2);
                byte[] byteArray = ((ByteArrayOutputStream) a00Var2.b).toByteArray();
                a00Var.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                a00Var.g((int) crc32.getValue());
                lc1.i(byteArrayOutputStream2);
                lc1.m(zzVar, a00Var);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                lc1.i(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void C(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        int i;
        int i2;
        int i3;
        int i4;
        ByteArrayOutputStream byteArrayOutputStream2;
        a00 a00Var;
        byte[] bArr;
        boolean z2;
        if (t) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        zz zzVar = new zz(bufferedInputStream, byteOrder);
        a00 a00Var2 = new a00(bufferedOutputStream, byteOrder);
        byte[] bArr2 = G;
        lc1.l(zzVar, a00Var2, bArr2.length);
        byte[] bArr3 = H;
        zzVar.a(bArr3.length + 4);
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                try {
                    a00 a00Var3 = new a00(byteArrayOutputStream4, byteOrder);
                    int i5 = this.o;
                    try {
                        try {
                            if (i5 != 0) {
                                lc1.l(zzVar, a00Var3, (i5 - ((bArr2.length + 4) + bArr3.length)) - 8);
                                zzVar.a(4);
                                int i6 = zzVar.readInt();
                                if (i6 % 2 != 0) {
                                    i6++;
                                }
                                zzVar.a(i6);
                                I(a00Var3);
                            } else {
                                byte[] bArr4 = new byte[4];
                                zzVar.readFully(bArr4);
                                byte[] bArr5 = K;
                                boolean zEquals = Arrays.equals(bArr4, bArr5);
                                byte[] bArr6 = M;
                                byte[] bArr7 = L;
                                if (!zEquals) {
                                    if (Arrays.equals(bArr4, bArr6) || Arrays.equals(bArr4, bArr7)) {
                                        int i7 = zzVar.readInt();
                                        int i8 = i7 % 2 == 1 ? i7 + 1 : i7;
                                        byte[] bArr8 = new byte[3];
                                        boolean zEquals2 = Arrays.equals(bArr4, bArr6);
                                        boolean z3 = true;
                                        byte[] bArr9 = J;
                                        if (zEquals2) {
                                            zzVar.readFully(bArr8);
                                            byte[] bArr10 = new byte[3];
                                            zzVar.readFully(bArr10);
                                            if (!Arrays.equals(bArr9, bArr10)) {
                                                throw new IOException("Error checking VP8 signature");
                                            }
                                            i = zzVar.readInt();
                                            i8 -= 10;
                                            i2 = (i << 18) >> 18;
                                            i3 = (i << 2) >> 18;
                                            z3 = false;
                                        } else if (!Arrays.equals(bArr4, bArr7)) {
                                            i = 0;
                                            i2 = 0;
                                            z3 = false;
                                            i3 = 0;
                                        } else {
                                            if (zzVar.readByte() != 47) {
                                                throw new IOException("Error checking VP8L signature");
                                            }
                                            i = zzVar.readInt();
                                            i2 = (i & 16383) + 1;
                                            i3 = ((i & 268419072) >>> 14) + 1;
                                            if ((i & 268435456) == 0) {
                                                z3 = false;
                                            }
                                            i8 -= 5;
                                        }
                                        a00Var3.write(bArr5);
                                        a00Var3.g(10);
                                        byte[] bArr11 = new byte[10];
                                        if (z3) {
                                            i4 = i2;
                                            bArr11[0] = (byte) (bArr11[0] | 16);
                                        } else {
                                            i4 = i2;
                                        }
                                        bArr11[0] = (byte) (bArr11[0] | 8);
                                        int i9 = i4 - 1;
                                        byteArrayOutputStream2 = byteArrayOutputStream4;
                                        int i10 = i3 - 1;
                                        a00Var = a00Var2;
                                        try {
                                            bArr11[4] = (byte) i9;
                                            bArr11[5] = (byte) (i9 >> 8);
                                            bArr11[6] = (byte) (i9 >> 16);
                                            bArr11[7] = (byte) i10;
                                            bArr11[8] = (byte) (i10 >> 8);
                                            bArr11[9] = (byte) (i10 >> 16);
                                            a00Var3.write(bArr11);
                                            a00Var3.write(bArr4);
                                            a00Var3.g(i7);
                                        } catch (Exception e) {
                                            e = e;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            byteArrayOutputStream3 = byteArrayOutputStream;
                                            throw new IOException("Failed to save WebP file", e);
                                        } catch (Throwable th) {
                                            th = th;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            byteArrayOutputStream3 = byteArrayOutputStream;
                                            lc1.i(byteArrayOutputStream3);
                                            throw th;
                                        }
                                        try {
                                            if (Arrays.equals(bArr4, bArr6)) {
                                                a00Var3.write(bArr8);
                                                a00Var3.write(bArr9);
                                                a00Var3.g(i);
                                            } else {
                                                if (Arrays.equals(bArr4, bArr7)) {
                                                    a00Var3.write(47);
                                                    a00Var3.g(i);
                                                }
                                                lc1.l(zzVar, a00Var3, i8);
                                                I(a00Var3);
                                            }
                                            lc1.l(zzVar, a00Var3, i8);
                                            I(a00Var3);
                                        } catch (Exception e2) {
                                            e = e2;
                                            byteArrayOutputStream3 = byteArrayOutputStream2;
                                            throw new IOException("Failed to save WebP file", e);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            byteArrayOutputStream3 = byteArrayOutputStream2;
                                            lc1.i(byteArrayOutputStream3);
                                            throw th;
                                        }
                                    }
                                    lc1.m(zzVar, a00Var3);
                                    a00 a00Var4 = a00Var;
                                    a00Var4.g(byteArrayOutputStream2.size() + bArr3.length);
                                    a00Var4.write(bArr3);
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayOutputStream.writeTo(a00Var4);
                                    lc1.i(byteArrayOutputStream);
                                    return;
                                }
                                int i11 = zzVar.readInt();
                                byte[] bArr12 = new byte[i11 % 2 == 1 ? i11 + 1 : i11];
                                zzVar.readFully(bArr12);
                                byte b = (byte) (8 | bArr12[0]);
                                bArr12[0] = b;
                                boolean z4 = ((b >> 1) & 1) == 1;
                                a00Var3.write(bArr5);
                                a00Var3.g(i11);
                                a00Var3.write(bArr12);
                                if (z4) {
                                    byte[] bArr13 = N;
                                    do {
                                        bArr = new byte[4];
                                        zzVar.readFully(bArr);
                                        int i12 = zzVar.readInt();
                                        a00Var3.write(bArr);
                                        a00Var3.g(i12);
                                        if (i12 % 2 == 1) {
                                            i12++;
                                        }
                                        lc1.l(zzVar, a00Var3, i12);
                                    } while (!Arrays.equals(bArr, bArr13));
                                    while (true) {
                                        byte[] bArr14 = new byte[4];
                                        try {
                                            zzVar.readFully(bArr14);
                                            z2 = !Arrays.equals(bArr14, O);
                                        } catch (EOFException unused) {
                                            z2 = true;
                                        }
                                        if (z2) {
                                            break;
                                        }
                                        int i13 = zzVar.readInt();
                                        a00Var3.write(bArr14);
                                        a00Var3.g(i13);
                                        if (i13 % 2 == 1) {
                                            i13++;
                                        }
                                        lc1.l(zzVar, a00Var3, i13);
                                    }
                                    I(a00Var3);
                                } else {
                                    while (true) {
                                        byte[] bArr15 = new byte[4];
                                        zzVar.readFully(bArr15);
                                        int i14 = zzVar.readInt();
                                        a00Var3.write(bArr15);
                                        a00Var3.g(i14);
                                        if (i14 % 2 == 1) {
                                            i14++;
                                        }
                                        lc1.l(zzVar, a00Var3, i14);
                                        if (Arrays.equals(bArr15, bArr6) || (bArr7 != null && Arrays.equals(bArr15, bArr7))) {
                                            break;
                                        }
                                    }
                                    I(a00Var3);
                                }
                            }
                            byteArrayOutputStream.writeTo(a00Var4);
                            lc1.i(byteArrayOutputStream);
                            return;
                        } catch (Exception e3) {
                            e = e3;
                            byteArrayOutputStream3 = byteArrayOutputStream;
                            throw new IOException("Failed to save WebP file", e);
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream3 = byteArrayOutputStream;
                            lc1.i(byteArrayOutputStream3);
                            throw th;
                        }
                        a00Var = a00Var2;
                        byteArrayOutputStream2 = byteArrayOutputStream4;
                        lc1.m(zzVar, a00Var3);
                        a00 a00Var42 = a00Var;
                        a00Var42.g(byteArrayOutputStream2.size() + bArr3.length);
                        a00Var42.write(bArr3);
                        byteArrayOutputStream = byteArrayOutputStream2;
                    } catch (Exception e4) {
                        e = e4;
                        byteArrayOutputStream3 = byteArrayOutputStream4;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream3 = byteArrayOutputStream4;
                    }
                } catch (Exception e5) {
                    e = e5;
                    byteArrayOutputStream = byteArrayOutputStream4;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = byteArrayOutputStream4;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x026a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instruction units count: 1094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f00.D(java.lang.String, java.lang.String):void");
    }

    public final void E(zz zzVar) throws Throwable {
        String str;
        b00 b00Var;
        int iH;
        HashMap map = this.e[4];
        b00 b00Var2 = (b00) map.get("Compression");
        if (b00Var2 == null) {
            this.n = 6;
            o(zzVar, map);
            return;
        }
        int iH2 = b00Var2.h(this.g);
        this.n = iH2;
        int i = 1;
        if (iH2 != 1) {
            if (iH2 == 6) {
                o(zzVar, map);
                return;
            } else if (iH2 != 7) {
                return;
            }
        }
        b00 b00Var3 = (b00) map.get("BitsPerSample");
        String str2 = "ExifInterface";
        if (b00Var3 != null) {
            int[] iArr = (int[]) b00Var3.j(this.g);
            int[] iArr2 = u;
            if (Arrays.equals(iArr2, iArr) || (this.d == 3 && (b00Var = (b00) map.get("PhotometricInterpretation")) != null && (((iH = b00Var.h(this.g)) == 1 && Arrays.equals(iArr, v)) || (iH == 6 && Arrays.equals(iArr, iArr2))))) {
                b00 b00Var4 = (b00) map.get("StripOffsets");
                b00 b00Var5 = (b00) map.get("StripByteCounts");
                if (b00Var4 == null || b00Var5 == null) {
                    return;
                }
                long[] jArrK = lc1.k(b00Var4.j(this.g));
                long[] jArrK2 = lc1.k(b00Var5.j(this.g));
                if (jArrK == null || jArrK.length == 0) {
                    Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (jArrK2 == null || jArrK2.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (jArrK.length != jArrK2.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j = 0;
                for (long j2 : jArrK2) {
                    j += j2;
                }
                int i2 = (int) j;
                byte[] bArr = new byte[i2];
                this.j = true;
                this.i = true;
                this.h = true;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < jArrK.length) {
                    int i6 = (int) jArrK[i3];
                    int i7 = (int) jArrK2[i3];
                    if (i3 < jArrK.length - i) {
                        str = str2;
                        if (i6 + i7 != jArrK[i3 + 1]) {
                            this.j = false;
                        }
                    } else {
                        str = str2;
                    }
                    int i8 = i6 - i4;
                    if (i8 < 0) {
                        Log.d(str, "Invalid strip offset value");
                        return;
                    }
                    String str3 = str;
                    try {
                        zzVar.a(i8);
                        int i9 = i4 + i8;
                        byte[] bArr2 = new byte[i7];
                        try {
                            zzVar.readFully(bArr2);
                            i4 = i9 + i7;
                            System.arraycopy(bArr2, 0, bArr, i5, i7);
                            i5 += i7;
                            i3++;
                            str2 = str3;
                            i = 1;
                        } catch (EOFException unused) {
                            Log.d(str3, "Failed to read " + i7 + " bytes.");
                            return;
                        }
                    } catch (EOFException unused2) {
                        Log.d(str3, "Failed to skip " + i8 + " bytes.");
                        return;
                    }
                }
                this.m = bArr;
                if (this.j) {
                    this.k = (int) jArrK[0];
                    this.l = i2;
                    return;
                }
                return;
            }
        }
        if (t) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void F(int i, int i2) throws Throwable {
        HashMap[] mapArr = this.e;
        boolean zIsEmpty = mapArr[i].isEmpty();
        boolean z2 = t;
        if (zIsEmpty || mapArr[i2].isEmpty()) {
            if (z2) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        b00 b00Var = (b00) mapArr[i].get("ImageLength");
        b00 b00Var2 = (b00) mapArr[i].get("ImageWidth");
        b00 b00Var3 = (b00) mapArr[i2].get("ImageLength");
        b00 b00Var4 = (b00) mapArr[i2].get("ImageWidth");
        if (b00Var == null || b00Var2 == null) {
            if (z2) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (b00Var3 == null || b00Var4 == null) {
            if (z2) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iH = b00Var.h(this.g);
        int iH2 = b00Var2.h(this.g);
        int iH3 = b00Var3.h(this.g);
        int iH4 = b00Var4.h(this.g);
        if (iH >= iH3 || iH2 >= iH4) {
            return;
        }
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    public final void G(e00 e00Var, int i) throws Throwable {
        b00 b00VarE;
        b00 b00VarE2;
        HashMap[] mapArr = this.e;
        b00 b00Var = (b00) mapArr[i].get("DefaultCropSize");
        b00 b00Var2 = (b00) mapArr[i].get("SensorTopBorder");
        b00 b00Var3 = (b00) mapArr[i].get("SensorLeftBorder");
        b00 b00Var4 = (b00) mapArr[i].get("SensorBottomBorder");
        b00 b00Var5 = (b00) mapArr[i].get("SensorRightBorder");
        if (b00Var != null) {
            int i2 = b00Var.a;
            ByteOrder byteOrder = this.g;
            if (i2 == 5) {
                d00[] d00VarArr = (d00[]) b00Var.j(byteOrder);
                if (d00VarArr == null || d00VarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(d00VarArr));
                    return;
                } else {
                    b00VarE = b00.d(new d00[]{d00VarArr[0]}, this.g);
                    b00VarE2 = b00.d(new d00[]{d00VarArr[1]}, this.g);
                }
            } else {
                int[] iArr = (int[]) b00Var.j(byteOrder);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                b00VarE = b00.e(iArr[0], this.g);
                b00VarE2 = b00.e(iArr[1], this.g);
            }
            mapArr[i].put("ImageWidth", b00VarE);
            mapArr[i].put("ImageLength", b00VarE2);
            return;
        }
        if (b00Var2 != null && b00Var3 != null && b00Var4 != null && b00Var5 != null) {
            int iH = b00Var2.h(this.g);
            int iH2 = b00Var4.h(this.g);
            int iH3 = b00Var5.h(this.g);
            int iH4 = b00Var3.h(this.g);
            if (iH2 <= iH || iH3 <= iH4) {
                return;
            }
            b00 b00VarE3 = b00.e(iH2 - iH, this.g);
            b00 b00VarE4 = b00.e(iH3 - iH4, this.g);
            mapArr[i].put("ImageLength", b00VarE3);
            mapArr[i].put("ImageWidth", b00VarE4);
            return;
        }
        b00 b00Var6 = (b00) mapArr[i].get("ImageLength");
        b00 b00Var7 = (b00) mapArr[i].get("ImageWidth");
        if (b00Var6 == null || b00Var7 == null) {
            b00 b00Var8 = (b00) mapArr[i].get("JPEGInterchangeFormat");
            b00 b00Var9 = (b00) mapArr[i].get("JPEGInterchangeFormatLength");
            if (b00Var8 == null || b00Var9 == null) {
                return;
            }
            int iH5 = b00Var8.h(this.g);
            int iH6 = b00Var8.h(this.g);
            e00Var.g(iH5);
            byte[] bArr = new byte[iH6];
            e00Var.readFully(bArr);
            e(new zz(bArr), iH5, i);
        }
    }

    public final void H() throws Throwable {
        F(0, 5);
        F(0, 4);
        F(5, 4);
        HashMap[] mapArr = this.e;
        b00 b00Var = (b00) mapArr[1].get("PixelXDimension");
        b00 b00Var2 = (b00) mapArr[1].get("PixelYDimension");
        if (b00Var != null && b00Var2 != null) {
            mapArr[0].put("ImageWidth", b00Var);
            mapArr[0].put("ImageLength", b00Var2);
        }
        if (mapArr[4].isEmpty() && q(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!q(mapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        y(0, "ThumbnailOrientation", "Orientation");
        y(0, "ThumbnailImageLength", "ImageLength");
        y(0, "ThumbnailImageWidth", "ImageWidth");
        y(5, "ThumbnailOrientation", "Orientation");
        y(5, "ThumbnailImageLength", "ImageLength");
        y(5, "ThumbnailImageWidth", "ImageWidth");
        y(4, "Orientation", "ThumbnailOrientation");
        y(4, "ImageLength", "ThumbnailImageLength");
        y(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final void I(a00 a00Var) throws IOException {
        HashMap[] mapArr;
        char c;
        char c2;
        int i;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        c00[][] c00VarArr = T;
        int[] iArr4 = new int[c00VarArr.length];
        int[] iArr5 = new int[c00VarArr.length];
        c00[] c00VarArr2 = U;
        for (c00 c00Var : c00VarArr2) {
            x(c00Var.b);
        }
        if (this.h) {
            if (this.i) {
                x("StripOffsets");
                x("StripByteCounts");
            } else {
                x("JPEGInterchangeFormat");
                x("JPEGInterchangeFormatLength");
            }
        }
        int i2 = 0;
        while (true) {
            int length = c00VarArr.length;
            mapArr = this.e;
            if (i2 >= length) {
                break;
            }
            Object[] array = mapArr[i2].entrySet().toArray();
            int length2 = array.length;
            int i3 = 0;
            while (i3 < length2) {
                Map.Entry entry = (Map.Entry) array[i3];
                if (entry.getValue() == null) {
                    iArr3 = iArr4;
                    mapArr[i2].remove(entry.getKey());
                } else {
                    iArr3 = iArr4;
                }
                i3++;
                iArr4 = iArr3;
            }
            i2++;
        }
        int[] iArr6 = iArr4;
        if (!mapArr[1].isEmpty()) {
            mapArr[0].put(c00VarArr2[1].b, b00.b(0L, this.g));
        }
        if (mapArr[2].isEmpty()) {
            c = 2;
        } else {
            c = 2;
            mapArr[0].put(c00VarArr2[2].b, b00.b(0L, this.g));
        }
        if (mapArr[3].isEmpty()) {
            c2 = 3;
        } else {
            c2 = 3;
            mapArr[1].put(c00VarArr2[3].b, b00.b(0L, this.g));
        }
        if (!this.h) {
            i = 1;
            iArr = iArr5;
        } else if (this.i) {
            mapArr[4].put("StripOffsets", b00.e(0, this.g));
            mapArr[4].put("StripByteCounts", b00.e(this.l, this.g));
            i = 1;
            iArr = iArr5;
        } else {
            mapArr[4].put("JPEGInterchangeFormat", b00.b(0L, this.g));
            i = 1;
            iArr = iArr5;
            mapArr[4].put("JPEGInterchangeFormatLength", b00.b(this.l, this.g));
        }
        int i4 = 0;
        while (true) {
            int length3 = c00VarArr.length;
            iArr2 = Q;
            if (i4 >= length3) {
                break;
            }
            Iterator it = mapArr[i4].entrySet().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                b00 b00Var = (b00) ((Map.Entry) it.next()).getValue();
                b00Var.getClass();
                int i6 = iArr2[b00Var.a] * b00Var.b;
                if (i6 > 4) {
                    i5 += i6;
                }
            }
            iArr[i4] = iArr[i4] + i5;
            i4++;
        }
        int size = 8;
        for (int i7 = 0; i7 < c00VarArr.length; i7++) {
            if (!mapArr[i7].isEmpty()) {
                iArr6[i7] = size;
                size = (mapArr[i7].size() * 12) + 6 + iArr[i7] + size;
            }
        }
        if (this.h) {
            if (this.i) {
                mapArr[4].put("StripOffsets", b00.e(size, this.g));
            } else {
                mapArr[4].put("JPEGInterchangeFormat", b00.b(size, this.g));
            }
            this.k = size;
            size += this.l;
        }
        if (this.d == 4) {
            size += 8;
        }
        if (t) {
            for (int i8 = 0; i8 < c00VarArr.length; i8++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i8), Integer.valueOf(iArr6[i8]), Integer.valueOf(mapArr[i8].size()), Integer.valueOf(iArr[i8]), Integer.valueOf(size)));
            }
        }
        if (!mapArr[i].isEmpty()) {
            mapArr[0].put(c00VarArr2[i].b, b00.b(iArr6[i], this.g));
        }
        if (!mapArr[c].isEmpty()) {
            mapArr[0].put(c00VarArr2[c].b, b00.b(iArr6[c], this.g));
        }
        if (!mapArr[c2].isEmpty()) {
            mapArr[i].put(c00VarArr2[c2].b, b00.b(iArr6[c2], this.g));
        }
        int i9 = this.d;
        if (i9 == 4) {
            if (size > 65535) {
                throw new IllegalStateException("Size of exif data (" + size + " bytes) exceeds the max size of a JPEG APP1 segment (65536 bytes)");
            }
            a00Var.m(size);
            a00Var.write(a0);
        } else if (i9 == 13) {
            a00Var.g(size);
            a00Var.write(D);
        } else if (i9 == 14) {
            a00Var.write(I);
            a00Var.g(size);
        }
        a00Var.h(this.g == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        a00Var.c = this.g;
        a00Var.m(42);
        a00Var.i(8L);
        for (int i10 = 0; i10 < c00VarArr.length; i10++) {
            if (!mapArr[i10].isEmpty()) {
                a00Var.m(mapArr[i10].size());
                int size2 = (mapArr[i10].size() * 12) + iArr6[i10] + 2 + 4;
                for (Map.Entry entry2 : mapArr[i10].entrySet()) {
                    int i11 = ((c00) W[i10].get(entry2.getKey())).a;
                    b00 b00Var2 = (b00) entry2.getValue();
                    b00Var2.getClass();
                    int i12 = b00Var2.b;
                    int i13 = b00Var2.a;
                    int i14 = iArr2[i13] * i12;
                    a00Var.m(i11);
                    a00Var.m(i13);
                    a00Var.g(i12);
                    if (i14 > 4) {
                        a00Var.i(size2);
                        size2 += i14;
                    } else {
                        a00Var.write(b00Var2.d);
                        if (i14 < 4) {
                            while (i14 < 4) {
                                a00Var.a(0);
                                i14++;
                            }
                        }
                    }
                }
                if (i10 != 0 || mapArr[4].isEmpty()) {
                    a00Var.i(0L);
                } else {
                    a00Var.i(iArr6[4]);
                }
                Iterator it2 = mapArr[i10].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = ((b00) ((Map.Entry) it2.next()).getValue()).d;
                    if (bArr.length > 4) {
                        a00Var.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.h) {
            a00Var.write(l());
        }
        if (this.d == 14 && size % 2 == i) {
            a00Var.a(0);
        }
        a00Var.c = ByteOrder.BIG_ENDIAN;
    }

    public final void a() {
        String strB = b("DateTimeOriginal");
        HashMap[] mapArr = this.e;
        if (strB != null && b("DateTime") == null) {
            mapArr[0].put("DateTime", b00.a(strB));
        }
        if (b("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", b00.b(0L, this.g));
        }
        if (b("ImageLength") == null) {
            mapArr[0].put("ImageLength", b00.b(0L, this.g));
        }
        if (b("Orientation") == null) {
            mapArr[0].put("Orientation", b00.b(0L, this.g));
        }
        if (b("LightSource") == null) {
            mapArr[1].put("LightSource", b00.b(0L, this.g));
        }
    }

    public final String b(String str) {
        if (str == null) {
            zy.r("tag shouldn't be null");
            return null;
        }
        b00 b00VarC = c(str);
        if (b00VarC != null) {
            int i = b00VarC.a;
            if (!X.contains(str)) {
                return b00VarC.i(this.g);
            }
            if (str.equals("GPSTimeStamp")) {
                if (i != 5 && i != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i);
                    return null;
                }
                d00[] d00VarArr = (d00[]) b00VarC.j(this.g);
                if (d00VarArr == null || d00VarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(d00VarArr));
                    return null;
                }
                d00 d00Var = d00VarArr[0];
                Integer numValueOf = Integer.valueOf((int) (d00Var.a / d00Var.b));
                d00 d00Var2 = d00VarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (d00Var2.a / d00Var2.b));
                d00 d00Var3 = d00VarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (d00Var3.a / d00Var3.b)));
            }
            try {
                return Double.toString(b00VarC.g(this.g));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final b00 c(String str) {
        if (str == null) {
            zy.r("tag shouldn't be null");
            return null;
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (t) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < T.length; i++) {
            b00 b00Var = (b00) this.e[i].get(str);
            if (b00Var != null) {
                return b00Var;
            }
        }
        return null;
    }

    public final void d(e00 e00Var) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        if (Build.VERSION.SDK_INT < 28) {
            zy.f("Reading EXIF from HEIF files is supported from SDK 28 and above");
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                h00.a(mediaMetadataRetriever, new yz(e00Var));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.e;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", b00.e(Integer.parseInt(strExtractMetadata), this.g));
                }
                if (strExtractMetadata2 != null) {
                    mapArr[0].put("ImageLength", b00.e(Integer.parseInt(strExtractMetadata2), this.g));
                }
                if (strExtractMetadata3 != null) {
                    int i = Integer.parseInt(strExtractMetadata3);
                    mapArr[0].put("Orientation", b00.e(i != 90 ? i != 180 ? i != 270 ? 1 : 8 : 3 : 6, this.g));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i2 = Integer.parseInt(strExtractMetadata4);
                    int i3 = Integer.parseInt(strExtractMetadata5);
                    if (i3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    e00Var.g(i2);
                    byte[] bArr = new byte[6];
                    e00Var.readFully(bArr);
                    int i4 = i2 + 6;
                    int i5 = i3 - 6;
                    if (!Arrays.equals(bArr, a0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i5];
                    e00Var.readFully(bArr2);
                    this.o = i4;
                    v(0, bArr2);
                }
                if (t) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final void e(defpackage.zz r24, int r25, int r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f00.e(zz, int, int):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:164|12|145|13|146|14|(16:17|(2:19|(1:21))(1:26)|27|(1:29)|30|(1:32)(13:33|(7:150|37|38|(2:40|173)(5:41|148|42|(1:44)(2:45|(1:47))|(1:175)(3:172|50|51))|52|34|35)|171|55|56|159|66|157|67|68|(1:74)(1:73)|75|(1:88)(8:154|90|152|91|92|(1:95)|96|(1:108)(2:110|(2:111|(2:113|(4:166|115|(2:116|(2:118|(1:168)(1:121))(3:167|122|(2:123|(2:125|(1:170)(1:128))(2:169|129))))|127)(1:131))(2:165|132)))))|61|(1:63)|(1:56)|159|66|157|67|68|(3:70|74|75)(0)|(0)(0))|16|159|66|157|67|68|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f4, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f5, code lost:
    
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f9, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00fb, code lost:
    
        if (r4 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00fd, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0100, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0101, code lost:
    
        if (r3 != null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0103, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0106, code lost:
    
        r0 = r19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010a A[RETURN] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(java.io.BufferedInputStream r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f00.f(java.io.BufferedInputStream):int");
    }

    public final void g(e00 e00Var) throws Throwable {
        int i;
        int i2;
        j(e00Var);
        HashMap[] mapArr = this.e;
        b00 b00Var = (b00) mapArr[1].get("MakerNote");
        if (b00Var != null) {
            e00 e00Var2 = new e00(b00Var.d);
            e00Var2.d = this.g;
            byte[] bArr = A;
            byte[] bArr2 = new byte[bArr.length];
            e00Var2.readFully(bArr2);
            e00Var2.g(0L);
            byte[] bArr3 = B;
            byte[] bArr4 = new byte[bArr3.length];
            e00Var2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                e00Var2.g(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                e00Var2.g(12L);
            }
            w(e00Var2, 6);
            b00 b00Var2 = (b00) mapArr[7].get("PreviewImageStart");
            b00 b00Var3 = (b00) mapArr[7].get("PreviewImageLength");
            if (b00Var2 != null && b00Var3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", b00Var2);
                mapArr[5].put("JPEGInterchangeFormatLength", b00Var3);
            }
            b00 b00Var4 = (b00) mapArr[8].get("AspectFrame");
            if (b00Var4 != null) {
                int[] iArr = (int[]) b00Var4.j(this.g);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                b00 b00VarE = b00.e(i5, this.g);
                b00 b00VarE2 = b00.e(i6, this.g);
                mapArr[0].put("ImageWidth", b00VarE);
                mapArr[0].put("ImageLength", b00VarE2);
            }
        }
    }

    public final void h(zz zzVar) throws Throwable {
        if (t) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + zzVar);
        }
        zzVar.d = ByteOrder.BIG_ENDIAN;
        byte[] bArr = C;
        zzVar.a(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i = zzVar.readInt();
                byte[] bArr2 = new byte[4];
                zzVar.readFully(bArr2);
                int i2 = length + 8;
                if (i2 == 16 && !Arrays.equals(bArr2, E)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, F)) {
                    return;
                }
                if (Arrays.equals(bArr2, D)) {
                    byte[] bArr3 = new byte[i];
                    zzVar.readFully(bArr3);
                    int i3 = zzVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i3) {
                        this.o = i2;
                        v(0, bArr3);
                        H();
                        E(new zz(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i3 + ", calculated CRC value: " + crc32.getValue());
                }
                int i4 = i + 4;
                zzVar.a(i4);
                length = i2 + i4;
            } catch (EOFException unused) {
                zy.p("Encountered corrupt PNG file.");
                return;
            }
        }
    }

    public final void i(zz zzVar) throws Throwable {
        boolean z2 = t;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + zzVar);
        }
        zzVar.a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        zzVar.readFully(bArr);
        zzVar.readFully(bArr2);
        zzVar.readFully(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        zzVar.a(i - zzVar.c);
        zzVar.readFully(bArr4);
        e(new zz(bArr4), i, 5);
        zzVar.a(i3 - zzVar.c);
        zzVar.d = ByteOrder.BIG_ENDIAN;
        int i4 = zzVar.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = zzVar.readUnsignedShort();
            int unsignedShort2 = zzVar.readUnsignedShort();
            if (unsignedShort == S.a) {
                short s = zzVar.readShort();
                short s2 = zzVar.readShort();
                b00 b00VarE = b00.e(s, this.g);
                b00 b00VarE2 = b00.e(s2, this.g);
                HashMap[] mapArr = this.e;
                mapArr[0].put("ImageLength", b00VarE);
                mapArr[0].put("ImageWidth", b00VarE2);
                if (z2) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s) + ", width: " + ((int) s2));
                    return;
                }
                return;
            }
            zzVar.a(unsignedShort2);
        }
    }

    public final void j(e00 e00Var) throws Throwable {
        s(e00Var);
        w(e00Var, 0);
        G(e00Var, 0);
        G(e00Var, 5);
        G(e00Var, 4);
        H();
        if (this.d == 8) {
            HashMap[] mapArr = this.e;
            b00 b00Var = (b00) mapArr[1].get("MakerNote");
            if (b00Var != null) {
                e00 e00Var2 = new e00(b00Var.d);
                e00Var2.d = this.g;
                e00Var2.a(6);
                w(e00Var2, 9);
                b00 b00Var2 = (b00) mapArr[9].get("ColorSpace");
                if (b00Var2 != null) {
                    mapArr[1].put("ColorSpace", b00Var2);
                }
            }
        }
    }

    public final void k(e00 e00Var) throws Throwable {
        if (t) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + e00Var);
        }
        j(e00Var);
        HashMap[] mapArr = this.e;
        b00 b00Var = (b00) mapArr[0].get("JpgFromRaw");
        if (b00Var != null) {
            e(new zz(b00Var.d), (int) b00Var.c, 5);
        }
        b00 b00Var2 = (b00) mapArr[0].get("ISO");
        b00 b00Var3 = (b00) mapArr[1].get("PhotographicSensitivity");
        if (b00Var2 == null || b00Var3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", b00Var2);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] l() throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "Error closing fd."
            java.lang.String r1 = "ExifInterfaceUtils"
            java.lang.String r2 = "ExifInterface"
            boolean r3 = r10.h
            r4 = 0
            if (r3 != 0) goto Ld
            goto L99
        Ld:
            byte[] r3 = r10.m
            if (r3 == 0) goto L12
            return r3
        L12:
            android.content.res.AssetManager$AssetInputStream r3 = r10.c     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            if (r3 == 0) goto L33
            boolean r5 = r3.markSupported()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L26
            if (r5 == 0) goto L2a
            r3.reset()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L26
        L1f:
            r5 = r4
            goto L5b
        L21:
            r10 = move-exception
            r5 = r4
        L23:
            r4 = r3
            goto L9a
        L26:
            r10 = move-exception
            r5 = r4
            goto L88
        L2a:
            java.lang.String r10 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r2, r10)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L26
            defpackage.lc1.i(r3)
            return r4
        L33:
            java.lang.String r3 = r10.a     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            if (r3 == 0) goto L46
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            java.lang.String r5 = r10.a     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            goto L1f
        L3f:
            r10 = move-exception
            r5 = r4
            goto L9a
        L42:
            r10 = move-exception
            r3 = r4
            r5 = r3
            goto L88
        L46:
            java.io.FileDescriptor r3 = r10.b     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            java.io.FileDescriptor r3 = defpackage.g00.b(r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            int r5 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            r6 = 0
            defpackage.g00.c(r3, r6, r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            r9 = r5
            r5 = r3
            r3 = r9
        L5b:
            zz r6 = new zz     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            int r7 = r10.k     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            int r8 = r10.o     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            int r7 = r7 + r8
            r6.a(r7)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            int r7 = r10.l     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            r6.readFully(r7)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            r10.m = r7     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            defpackage.lc1.i(r3)
            if (r5 == 0) goto L7d
            defpackage.g00.a(r5)     // Catch: java.lang.Exception -> L7a
            return r7
        L7a:
            android.util.Log.e(r1, r0)
        L7d:
            return r7
        L7e:
            r10 = move-exception
            goto L23
        L80:
            r10 = move-exception
            goto L88
        L82:
            r10 = move-exception
            r5 = r3
            goto L9a
        L85:
            r10 = move-exception
            r5 = r3
            r3 = r4
        L88:
            java.lang.String r6 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r2, r6, r10)     // Catch: java.lang.Throwable -> L7e
            defpackage.lc1.i(r3)
            if (r5 == 0) goto L99
            defpackage.g00.a(r5)     // Catch: java.lang.Exception -> L96
            goto L99
        L96:
            android.util.Log.e(r1, r0)
        L99:
            return r4
        L9a:
            defpackage.lc1.i(r4)
            if (r5 == 0) goto La6
            defpackage.g00.a(r5)     // Catch: java.lang.Exception -> La3
            goto La6
        La3:
            android.util.Log.e(r1, r0)
        La6:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f00.l():byte[]");
    }

    public final void m(zz zzVar) throws Throwable {
        if (t) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + zzVar);
        }
        zzVar.d = ByteOrder.LITTLE_ENDIAN;
        zzVar.a(G.length);
        int i = zzVar.readInt() + 8;
        byte[] bArr = H;
        zzVar.a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                zzVar.readFully(bArr2);
                int i2 = zzVar.readInt();
                int i3 = length + 8;
                if (Arrays.equals(I, bArr2)) {
                    byte[] bArr3 = new byte[i2];
                    zzVar.readFully(bArr3);
                    this.o = i3;
                    v(0, bArr3);
                    E(new zz(bArr3));
                    return;
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                length = i3 + i2;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                zzVar.a(i2);
            } catch (EOFException unused) {
                zy.p("Encountered corrupt WebP file.");
                return;
            }
        }
    }

    public final void o(zz zzVar, HashMap map) throws Throwable {
        b00 b00Var = (b00) map.get("JPEGInterchangeFormat");
        b00 b00Var2 = (b00) map.get("JPEGInterchangeFormatLength");
        if (b00Var == null || b00Var2 == null) {
            return;
        }
        int iH = b00Var.h(this.g);
        int iH2 = b00Var2.h(this.g);
        if (this.d == 7) {
            iH += this.p;
        }
        if (iH > 0 && iH2 > 0) {
            this.h = true;
            if (this.a == null && this.c == null && this.b == null) {
                byte[] bArr = new byte[iH2];
                zzVar.a(iH);
                zzVar.readFully(bArr);
                this.m = bArr;
            }
            this.k = iH;
            this.l = iH2;
        }
        if (t) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iH + ", length: " + iH2);
        }
    }

    public final void p(String str) throws Throwable {
        FileInputStream fileInputStream;
        boolean z2;
        if (str == null) {
            zy.r("filename cannot be null");
            return;
        }
        FileInputStream fileInputStream2 = null;
        this.c = null;
        this.a = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                g00.c(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                z2 = true;
            } catch (Exception unused) {
                if (t) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
                z2 = false;
            }
            if (z2) {
                this.b = fileInputStream.getFD();
            } else {
                this.b = null;
            }
            r(fileInputStream);
            lc1.i(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            lc1.i(fileInputStream2);
            throw th;
        }
    }

    public final boolean q(HashMap map) {
        b00 b00Var = (b00) map.get("ImageLength");
        b00 b00Var2 = (b00) map.get("ImageWidth");
        if (b00Var == null || b00Var2 == null) {
            return false;
        }
        return b00Var.h(this.g) <= 512 && b00Var2.h(this.g) <= 512;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008f A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:3:0x0004, B:5:0x0009, B:12:0x001e, B:18:0x003b, B:20:0x0046, B:28:0x005c, B:23:0x004d, B:26:0x0055, B:27:0x0059, B:29:0x0066, B:31:0x006f, B:33:0x0075, B:35:0x007b, B:37:0x0081, B:43:0x008f), top: B:53:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.io.InputStream r8) {
        /*
            r7 = this;
            boolean r0 = defpackage.f00.t
            r1 = 0
            r2 = r1
        L4:
            c00[][] r3 = defpackage.f00.T     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r3 = r3.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r2 >= r3) goto L1e
            java.util.HashMap[] r3 = r7.e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.<init>()     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3[r2] = r4     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r2 + 1
            goto L4
        L15:
            r8 = move-exception
            goto L97
        L18:
            r8 = move-exception
            goto L8d
        L1b:
            r8 = move-exception
            goto L8d
        L1e:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3 = 5000(0x1388, float:7.006E-42)
            r2.<init>(r8, r3)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r8 = r7.f(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r7.d = r8     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3 = 14
            r4 = 13
            r5 = 9
            r6 = 4
            if (r8 == r6) goto L66
            if (r8 == r5) goto L66
            if (r8 == r4) goto L66
            if (r8 != r3) goto L3b
            goto L66
        L3b:
            e00 r8 = new e00     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r1 = r7.d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 12
            if (r1 != r2) goto L4a
            r7.d(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L5c
        L4a:
            r2 = 7
            if (r1 != r2) goto L51
            r7.g(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L5c
        L51:
            r2 = 10
            if (r1 != r2) goto L59
            r7.k(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L5c
        L59:
            r7.j(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L5c:
            int r1 = r7.o     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.g(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r7.E(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L66:
            zz r8 = new zz     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r7.d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r2 != r6) goto L73
            r7.e(r8, r1, r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L73:
            if (r2 != r4) goto L79
            r7.h(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L79:
            if (r2 != r5) goto L7f
            r7.i(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L7f:
            if (r2 != r3) goto L84
            r7.m(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L84:
            r7.a()
            if (r0 == 0) goto La8
            r7.t()
            return
        L8d:
            if (r0 == 0) goto La0
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r8)     // Catch: java.lang.Throwable -> L15
            goto La0
        L97:
            r7.a()
            if (r0 == 0) goto L9f
            r7.t()
        L9f:
            throw r8
        La0:
            r7.a()
            if (r0 == 0) goto La8
            r7.t()
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f00.r(java.io.InputStream):void");
    }

    public final void s(e00 e00Var) throws IOException {
        ByteOrder byteOrderU = u(e00Var);
        this.g = byteOrderU;
        e00Var.d = byteOrderU;
        int unsignedShort = e00Var.readUnsignedShort();
        int i = this.d;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            zy.o("Invalid start code: ", Integer.toHexString(unsignedShort));
            return;
        }
        int i2 = e00Var.readInt();
        if (i2 < 8) {
            zy.p(qq0.i("Invalid first Ifd offset: ", i2));
            return;
        }
        int i3 = i2 - 8;
        if (i3 > 0) {
            e00Var.a(i3);
        }
    }

    public final void t() {
        int i = 0;
        while (true) {
            HashMap[] mapArr = this.e;
            if (i >= mapArr.length) {
                return;
            }
            Log.d("ExifInterface", "The size of tag group[" + i + "]: " + mapArr[i].size());
            for (Map.Entry entry : mapArr[i].entrySet()) {
                b00 b00Var = (b00) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + b00Var.toString() + ", tagValue: '" + b00Var.i(this.g) + "'");
            }
            i++;
        }
    }

    public final void v(int i, byte[] bArr) throws IOException {
        e00 e00Var = new e00(bArr);
        s(e00Var);
        w(e00Var, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(defpackage.e00 r30, int r31) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f00.w(e00, int):void");
    }

    public final void x(String str) {
        for (int i = 0; i < T.length; i++) {
            this.e[i].remove(str);
        }
    }

    public final void y(int i, String str, String str2) {
        HashMap[] mapArr = this.e;
        if (mapArr[i].isEmpty() || mapArr[i].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i];
        map.put(str2, map.get(str));
        mapArr[i].remove(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f3 A[Catch: all -> 0x0103, Exception -> 0x0106, TryCatch #18 {Exception -> 0x0106, all -> 0x0103, blocks: (B:79:0x00ef, B:81:0x00f3, B:88:0x0111, B:87:0x0109), top: B:128:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0109 A[Catch: all -> 0x0103, Exception -> 0x0106, TryCatch #18 {Exception -> 0x0106, all -> 0x0103, blocks: (B:79:0x00ef, B:81:0x00f3, B:88:0x0111, B:87:0x0109), top: B:128:0x00ef }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z() {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f00.z():void");
    }

    public f00(String str) throws Throwable {
        c00[][] c00VarArr = T;
        this.e = new HashMap[c00VarArr.length];
        this.f = new HashSet(c00VarArr.length);
        this.g = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            p(str);
        } else {
            zy.r("filename cannot be null");
            throw null;
        }
    }

    public f00(File file) throws Throwable {
        c00[][] c00VarArr = T;
        this.e = new HashMap[c00VarArr.length];
        this.f = new HashSet(c00VarArr.length);
        this.g = ByteOrder.BIG_ENDIAN;
        p(file.getAbsolutePath());
    }
}
