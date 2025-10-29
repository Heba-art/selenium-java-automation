<table border="1" style="width:100%; border-collapse: collapse; font-family: sans-serif; font-size: 14px;">
  <thead>
    <tr style="background-color:#007bff; color:white;">
      <th style="padding: 10px; text-align: left;">ID</th>
      <th style="padding: 10px; text-align: left;">Module</th>
      <th style="padding: 10px; text-align: left;">Title</th>
      <th style="padding: 10px; text-align: left;">Priority</th>
      <th style="padding: 10px; text-align: left;">Type</th>
      <th style="padding: 10px; text-align: left;">Precondition</th>
      <th style="padding: 10px; text-align: left;">Steps</th>
      <th style="padding: 10px; text-align: left;">Expected Result</th>
      <th style="padding: 10px; text-align: left;">Actual Result</th>
    </tr>
  </thead>
  <tbody>
    <tr style="background-color:#f9f9f9;">
      <td style="padding: 8px;"><b>TC-SD-001</b></td>
      <td style="padding: 8px;">Login</td>
      <td style="padding: 8px;">Login valid (success)</td>
      <td style="padding: 8px;">High</td>
      <td style="padding: 8px;">Positive</td>
      <td style="padding: 8px;">Browser open on Login page</td>
      <td style="padding: 8px;">1. Enter username = <code>standard_user</code><br>2. Enter password = <code>secret_sauce</code><br>3. Click Login</td>
      <td style="padding: 8px;">Redirected to Products page. Header shows "Products".</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr>
      <td style="padding: 8px;"><b>TC-SD-002</b></td>
      <td style="padding: 8px;">Login</td>
      <td style="padding: 8px;">Login invalid password</td>
      <td style="padding: 8px;">High</td>
      <td style="padding: 8px;">Negative</td>
      <td style="padding: 8px;">Browser open on Login page</td>
      <td style="padding: 8px;">1. Enter username = <code>standard_user</code><br>2. Enter password = <code>wrong_pass</code><br>3. Click Login</td>
      <td style="padding: 8px;">Error message displayed: *...Username and password do not match...*</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr style="background-color:#f9f9f9;">
      <td style="padding: 8px;"><b>TC-SD-003</b></td>
      <td style="padding: 8px;">Login</td>
      <td style="padding: 8px;">Locked-out user blocked</td>
      <td style="padding: 8px;">High</td>
      <td style="padding: 8px;">Negative</td>
      <td style="padding: 8px;">Browser open on Login page</td>
      <td style="padding: 8px;">1. Enter username = <code>locked_out_user</code><br>2. Enter password = <code>secret_sauce</code><br>3. Click Login</td>
      <td style="padding: 8px;">Error message displayed: *...this user has been locked out.*</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr>
      <td style="padding: 8px;"><b>TC-SD-004</b></td>
      <td style="padding: 8px;">Cart</td>
      <td style="padding: 8px;">Add single item to cart</td>
      <td style="padding: 8px;">High</td>
      <td style="padding: 8px;">Positive</td>
      <td style="padding: 8px;">Logged in, on Products page</td>
      <td style="padding: 8px;">1. Click *Add to cart* for "Sauce Labs Backpack"<br>2. Open cart</td>
      <td style="padding: 8px;">Cart badge = 1. Cart shows "Sauce Labs Backpack".</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr style="background-color:#f9f9f9;">
      <td style="padding: 8px;"><b>TC-SD-005</b></td>
      <td style="padding: 8px;">Cart</td>
      <td style="padding: 8px;">Remove item from cart</td>
      <td style="padding: 8px;">High</td>
      <td style="padding: 8px;">Positive</td>
      <td style="padding: 8px;">One item already in cart</td>
      <td style="padding: 8px;">1. On Cart page, click *Remove*</td>
      <td style="padding: 8px;">No items in cart. Cart badge disappears.</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr>
      <td style="padding: 8px;"><b>TC-SD-006</b></td>
      <td style="padding: 8px;">Checkout</td>
      <td style="padding: 8px;">Complete checkout flow</td>
      <td style="padding: 8px;">High</td>
      <td style="padding: 8px;">E2E</td>
      <td style="padding: 8px;">Logged in + 1 product in cart</td>
      <td style="padding: 8px;">1. Click Checkout<br>2. Fill info<br>3. Click Continue<br>4. Click Finish</td>
      <td style="padding: 8px;">Redirected to "Checkout: Complete!" page.</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr style="background-color:#f9f9f9;">
      <td style="padding: 8px;"><b>TC-SD-006-N</b></td>
      <td style="padding: 8px;">Checkout</td>
      <td style="padding: 8px;">Checkout with missing required field</td>
      <td style="padding: 8px;">High</td>
      <td style="padding: 8px;">Negative</td>
      <td style="padding: 8px;">Logged in + 1 product in cart (on Cart page)</td>
      <td style="padding: 8px;">1. Click <i>Checkout</i><br>2. Leave <b>First Name</b> empty (fill Last Name &amp; Postal Code)<br>3. Click <i>Continue</i></td>
      <td style="padding: 8px;">Stays on <b>Checkout: Your Information</b> and shows error:<br><i>Error: First Name is required</i>.</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr>
      <td style="padding: 8px;"><b>TC-SD-007</b></td>
      <td style="padding: 8px;">Products</td>
      <td style="padding: 8px;">Sort products by Price (low→high)</td>
      <td style="padding: 8px;">Medium</td>
      <td style="padding: 8px;">Functional</td>
      <td style="padding: 8px;">Logged in, on Products page</td>
      <td style="padding: 8px;">1. Open sorting dropdown<br>2. Select *Price (low to high)*</td>
      <td style="padding: 8px;">Products displayed in ascending order by price.</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr style="background-color:#f9f9f9;">
      <td style="padding: 8px;"><b>TC-SD-008</b></td>
      <td style="padding: 8px;">Cart</td>
      <td style="padding: 8px;">Cart state persists after navigation</td>
      <td style="padding: 8px;">Medium</td>
      <td style="padding: 8px;">Functional</td>
      <td style="padding: 8px;">Logged in, on Products page</td>
      <td style="padding: 8px;">1. Add item<br>2. Open cart<br>3. Click *Continue Shopping*</td>
      <td style="padding: 8px;">Cart badge still = 1.</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr>
      <td style="padding: 8px;"><b>TC-SD-009</b></td>
      <td style="padding: 8px;">Login</td>
      <td style="padding: 8px;">Logout & access protection</td>
      <td style="padding: 8px;">High</td>
      <td style="padding: 8px;">Security</td>
      <td style="padding: 8px;">Logged in, on Products page</td>
      <td style="padding: 8px;">1. Open menu<br>2. Click Logout<br>3. Try to access <code>/inventory.html</code></td>
      <td style="padding: 8px;">Redirected to Login page. Access denied.</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr style="background-color:#f9f9f9;">
      <td style="padding: 8px;"><b>TC-SD-010</b></td>
      <td style="padding: 8px;">Products</td>
      <td style="padding: 8px;">Product details page</td>
      <td style="padding: 8px;">Medium</td>
      <td style="padding: 8px;">Functional</td>
      <td style="padding: 8px;">Logged in, on Products page</td>
      <td style="padding: 8px;">1. Click product name<br>2. Click *Back to Products*</td>
      <td style="padding: 8px;">Product details page loads correctly. Back button works.</td>
      <td style="padding: 8px; color: green;">✅ Pass</td>
    </tr>
    <tr style="background-color:#f9f9f9;">
  <td style="padding: 8px;"><b>TC-SD-011</b></td>
  <td style="padding: 8px;">Products</td>
  <td style="padding: 8px;">Sort products by Name (A→Z)</td>
  <td style="padding: 8px;">Medium</td>
  <td style="padding: 8px;">Functional</td>
  <td style="padding: 8px;">Logged in, on Products page</td>
  <td style="padding: 8px;">1. Open sorting dropdown<br>2. Select <i>Name (A to Z)</i></td>
  <td style="padding: 8px;">Products listed in ascending alphabetical order by name.</td>
  <td style="padding: 8px;">✅ Pass</td>
</tr>

<tr>
  <td style="padding: 8px;"><b>TC-SD-012</b></td>
  <td style="padding: 8px;">Checkout</td>
  <td style="padding: 8px;">Verify totals &amp; tax on Overview</td>
  <td style="padding: 8px;">High</td>
  <td style="padding: 8px;">Functional</td>
  <td style="padding: 8px;">Logged in; add <b>Sauce Labs Backpack</b> ($29.99) and <b>Sauce Labs Bike Light</b> ($9.99) to cart</td>
  <td style="padding: 8px;">1. Open cart → <i>Checkout</i><br>2. Fill info → <i>Continue</i> (Overview page)</td>
  <td style="padding: 8px;">Item total = <b>$39.98</b>; Tax = <b>$3.20</b> (8%); Total = <b>$43.18</b>.</td>
  <td style="padding: 8px;">—</td>
</tr>

<tr style="background-color:#f9f9f9;">
  <td style="padding: 8px;"><b>TC-SD-013</b></td>
  <td style="padding: 8px;">App State</td>
  <td style="padding: 8px;">Reset App State clears cart</td>
  <td style="padding: 8px;">High</td>
  <td style="padding: 8px;">Functional</td>
  <td style="padding: 8px;">Logged in; ≥1 item in cart</td>
  <td style="padding: 8px;">1. Open left menu<br>2. Click <i>Reset App State</i><br>3. Open cart</td>
  <td style="padding: 8px;">Cart empty; badge disappears; product buttons reset to <i>Add to cart</i>.</td>
  <td style="padding: 8px;">—</td>
</tr>

<tr>
  <td style="padding: 8px;"><b>TC-SD-014</b></td>
  <td style="padding: 8px;">Checkout</td>
  <td style="padding: 8px;">Cancel from Overview returns to Cart</td>
  <td style="padding: 8px;">Medium</td>
  <td style="padding: 8px;">UX</td>
  <td style="padding: 8px;">Logged in; ≥1 item in cart; on <b>Checkout: Overview</b> page</td>
  <td style="padding: 8px;">1. Click <i>Cancel</i></td>
  <td style="padding: 8px;">Redirected to Cart page; all previously added items still present.</td>
  <td style="padding: 8px;">—</td>
</tr>

<tr style="background-color:#f9f9f9;">
  <td style="padding: 8px;"><b>TC-SD-015</b></td>
  <td style="padding: 8px;">Products</td>
  <td style="padding: 8px;">PDP add → back preserves state</td>
  <td style="padding: 8px;">Medium</td>
  <td style="padding: 8px;">Functional</td>
  <td style="padding: 8px;">Logged in, on Products page</td>
  <td style="padding: 8px;">1. Open a product PDP<br>2. Click <i>Add to cart</i><br>3. Click <i>Back to Products</i></td>
  <td style="padding: 8px;">Cart badge increments; that product’s button shows <i>Remove</i> on listing.</td>
  <td style="padding: 8px;">—</td>
</tr>
<tr>
  <td style="padding: 8px;"><b>TC-SD-016</b></td>
  <td style="padding: 8px;">Products</td>
  <td style="padding: 8px;">Sort products by Name (Z→A)</td>
  <td style="padding: 8px;">Medium</td>
  <td style="padding: 8px;">Functional</td>
  <td style="padding: 8px;">Logged in, on Products page</td>
  <td style="padding: 8px;">1. Open sorting dropdown<br>2. Select <i>Name (Z to A)</i></td>
  <td style="padding: 8px;">Products listed in descending alphabetical order by name.</td>
  <td style="padding: 8px;">—</td>
</tr>

<tr style="background-color:#f9f9f9;">
  <td style="padding: 8px;"><b>TC-SD-017</b></td>
  <td style="padding: 8px;">Products</td>
  <td style="padding: 8px;">Sort products by Price (high→low)</td>
  <td style="padding: 8px;">Medium</td>
  <td style="padding: 8px;">Functional</td>
  <td style="padding: 8px;">Logged in, on Products page</td>
  <td style="padding: 8px;">1. Open sorting dropdown<br>2. Select <i>Price (high to low)</i></td>
  <td style="padding: 8px;">Products displayed in descending order by price.</td>
  <td style="padding: 8px;">—</td>
</tr>

<tr>
  <td style="padding: 8px;"><b>TC-SD-018</b></td>
  <td style="padding: 8px;">Products</td>
  <td style="padding: 8px;">Sort order persists after PDP navigation</td>
  <td style="padding: 8px;">Low</td>
  <td style="padding: 8px;">UX</td>
  <td style="padding: 8px;">Logged in; Products sorted (e.g., <i>Price (low to high)</i>)</td>
  <td style="padding: 8px;">1. Click any product to open PDP<br>2. Click <i>Back to Products</i></td>
  <td style="padding: 8px;">Returned list keeps previously selected sort order.</td>
  <td style="padding: 8px;">—</td>
</tr>

<tr style="background-color:#f9f9f9;">
  <td style="padding: 8px;"><b>TC-SD-019</b></td>
  <td style="padding: 8px;">Cart</td>
  <td style="padding: 8px;">Remove from Products page updates badge</td>
  <td style="padding: 8px;">High</td>
  <td style="padding: 8px;">Functional</td>
  <td style="padding: 8px;">Logged in; at least 1 item already added from Products page</td>
  <td style="padding: 8px;">1. On Products list, click <i>Remove</i> on that item</td>
  <td style="padding: 8px;">Button toggles back to <i>Add to cart</i>; cart badge decrements accordingly.</td>
  <td style="padding: 8px;">—</td>
</tr>

<tr>
  <td style="padding: 8px;"><b>TC-SD-020</b></td>
  <td style="padding: 8px;">Checkout</td>
  <td style="padding: 8px;">Checkout with missing Postal Code</td>
  <td style="padding: 8px;">High</td>
  <td style="padding: 8px;">Negative</td>
  <td style="padding: 8px;">Logged in; 1 product in cart; on <b>Checkout: Your Information</b></td>
  <td style="padding: 8px;">1. Fill <i>First Name</i> &amp; <i>Last Name</i><br>2. Leave <i>Postal Code</i> empty<br>3. Click <i>Continue</i></td>
  <td style="padding: 8px;">Validation error shown: <i>Error: Postal Code is required</i>; remains on the Information step.</td>
  <td style="padding: 8px;">—</td>
</tr>
  </tbody>
</table>
