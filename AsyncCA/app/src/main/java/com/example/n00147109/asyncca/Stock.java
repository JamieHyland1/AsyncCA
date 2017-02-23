package com.example.n00147109.asyncca;

/**
 * Created by N00147109 on 23/02/2017.
 */
public class Stock
{
    private String ticker;
    private String date;
    private double open;
    private double close;
    private double high;
    private double low;

    public Stock(){

    }
    public Stock(String tck,String dte, double opn, double cls, double high, double low)
    {
        this.setTicker(tck);
        this.setDate(dte);
        this.setOpen(opn);
        this.setClose(cls);
        this.setHigh(high);
        this.setLow(low);
    }

    public String getTicker()
    {
        return ticker;
    }

    public void setTicker(String ticker)
    {
        this.ticker = ticker;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public double getOpen()
    {
        return open;
    }

    public void setOpen(double open)
    {
        this.open = open;
    }

    public double getClose()
    {
        return close;
    }

    public void setClose(double close)
    {
        this.close = close;
    }

    public double getHigh()
    {
        return high;
    }

    public void setHigh(double high)
    {
        this.high = high;
    }

    public double getLow()
    {
        return low;
    }

    public void setLow(double low)
    {
        this.low = low;
    }
}
