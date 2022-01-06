package fr.ringularity.infinite_power.utils;

public final class StringFormat {
    public static String engineOn(double value) {
        final int unit = 1000;
        if (value < unit) return String.format("%.0f", value);
        final int exp = (int) (Math.log(value) / Math.log(unit));
        final char pre = "KMGTPEZYXWV".charAt(exp - 1);
        String displayedVal = String.format("%.2f", value / Math.pow(unit, exp));
        if (displayedVal.charAt(displayedVal.length() - 1) == '0' && displayedVal.charAt(displayedVal.length() - 2) == '0')
            displayedVal = displayedVal.substring(0, displayedVal.length() - 3);
        return displayedVal + pre;
    }

    public static String simplifiedPercentage(double per) {
        if (per == 0)
            return "0%";
        if (per == (long) per)
            return (long) per + "%";
        return String.format("%.2f", per) + "%";
    }

    public static String percentage(double per) {
        return String.format("%.2f", per) + "%";
    }

    public static String percentage(double val, double maxVal) {
        return percentage(val / maxVal);
    }

    public static String getDisplayName(String s) {
        return (s.substring(0, 1).toUpperCase() + s.substring(1)).replace("_", " ");
    }
}

