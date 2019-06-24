package application.divideandconquer;


class MergeSortImpl
{
    private int[] input;
    private int[] temp;
    private long count;


    public MergeSortImpl(int[] input)
    {
        this.input = input;
    }

    public long countOfInversion()
    {
        temp = new int[input.length];
        mergeSort(0, input.length);
        return count;
    }

    private void mergeSort(int l, int r)
    {
        if(r <= (l + 1))
            return;
        //a[l..r-1] -> a[l..m-1] a[m..r-1]
        int m = (l + r) >> 1;
        mergeSort(l, m);
        mergeSort(m, r);
        merge(l, m, r);
    }

    private void merge(int l, int m, int r)
    {
        //input[l..m-1] input[m..r-1] -> temp[l..r-1] ->a[l..r-1]
        int i = l;
        int j = m;
        for(int k = l; k < r; k++)
        {
            if(j == r || (i < m && input[i] <= input[j]))
            {
                temp[k] = input[i];
                i++;
            } else
            {
                count += m - i;
                temp[k] = input[j];
                j++;
            }
        }
        System.arraycopy(temp, l, input, l, r - l);

    }
}
