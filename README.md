# searchable-spinner
Android Spinner is modified to give a search inside to filter spinner contents and choose quickly. Choosing an option from a large dropdown is frustrating when you have no way to quickly search an item through. This library solves the issue.

## Get Started

Just add SearchableSpinner in your layout file as

```
<com.azim.spinner.SearchableSpinner
        android:id="@+id/spinner1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="16dp" />
```

Also we have two attributes to apply as

```
app:defaultText="Select one..."
app:invalidTextColor="@color/colorAccent"
```

That will be applied to the view. Default text is displayed when nothing is selected and invalid text color is applied when the entered query doesn't match with any item in the spinner.

Declare spinner dataset

```
<string-array name="countries_array">
        <item>Afghanistan</item>
        <item>Albania</item>
        <item>Algeria</item>
        <item>American Samoa</item>
        <item>Australia</item>
        <item>Austria</item>
        <item>Azerbaijan</item>
        <item>Bahrain</item>
        <item>Bangladesh</item>
        <item>Brazil</item>
        <item>British Indian Ocean Territory</item>
        <item>British Virgin Islands</item>
        <item>Brunei</item>
        <item>Bulgaria</item>
        <item>Burkina Faso</item>
        <item>Burundi</item>
        <item>Cambodia</item>
        <item>Dominican Republic</item>
        <item>Ireland</item>
        <item>Israel</item>
        <item>Italy</item>
        <item>Jamaica</item>
        <item>Japan</item>
        <item>Jordan</item>
        <item>Kazakhstan</item>
        <item>Kenya</item>
        <item>Liberia</item>
        <item>Libya</item>
        <item>Romania</item>
        <item>Yemen</item>
        <item>Yugoslavia</item>
        <item>Zambia</item>
        <item>Zimbabwe</item>
    </string-array>
    
    
    Initialize spiiner with this data
    
        String[] data = getResources().getStringArray(R.array.countries_array);
    
        SearchableSpinner spinner1 = (SearchableSpinner) findViewById(R.id.spinner1);

        spinner1.setData(data);

        spinner1.setDefaultText("Select country");
        spinner1.setInvalidTextColor(getResources().getColor(R.color.colorAccent));

        spinner1.setSelectionListener(new SearchableSpinner.OnSelectionListener() {
            @Override
            public void onSelect(int spinnerId, int position, String value) {
                Log.i("Select1", "Position : " + position + " : Value : " + value + " : " + spinnerId);
            }
        });
    
    And thats it
