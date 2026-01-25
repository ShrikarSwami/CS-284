//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    int arr[] = {5,7,3,6,2,7,3,7,5,7,8};

    System.out.println("Original Array: ");
    for(int i=0;i<arr.length;i++)
        System.out.print(arr[i] + " ");

    for(int i=0;i<arr.length;i++) {
        for (int j=i+1;j<arr.length;j++) {
            if(arr[i]>arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    System.out.println("Sorted Array: ");
    for(int i=0;i<arr.length;i++)
        System.out.print(arr[i] + " ");

}
