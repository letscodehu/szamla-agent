# Szamla-Agent [![Build Status](https://travis-ci.org/letscodehu/szamla-agent.svg?branch=master)](https://travis-ci.org/letscodehu/szamla-agent)

Java client implementation against the szamlazz.hu billing API.

## Usage: 

As a usual client you should instantiate `hu.letscode.billing.service.factory.BillingServiceFactory` and then create 
your own service with `createSzamlaAgent` method by passing two previously created objects:

```
BillingServiceFactory serviceFactory = new BillingServiceFactory();
SzamlaAgentBillingService billingService = serviceFactory.createSzamlaAgent(seller, settings);
```

The `hu.letscode.billing.domain.Seller` contains information about the selling entity.
```
Seller seller = new Seller();
seller.setAccountNumber("555555555-55555555-55555555");
seller.setBankName("whateverbank");
seller.setEmailContent("Pay your bill please");
seller.setEmailSubject("Invoice");
seller.setSellerSignatory("John Doe");
```  
The `hu.letscode.billing.domain.Settings` contains information about the account you registered at szamlazz.hu and using szamlazz client with. 
```
Settings settings = new Settings();
settings.setAnswerType(2);
settings.setDownloadBill(false);
settings.seteBill(false);
settings.setUser("letscodehu");
settings.setPassword("password");
settings.setKeyChainPassword("");
```
As you provide these information at the creation of the service, currently you could create a client which only 
creates bills on behalf of a single entity.

When you got the service up and running you could invoice bills with the `createBill` method. You only need to create
 `BillingRequest`'s.

```
BillingRequest billingRequest = new BillingRequest();
billingRequest.setBuyer(createBuyer());
billingRequest.setSeller(createSeller());
billingRequest.setHeader(createHeader());
billingRequest.setItems(createItemList());

billingService.createBill(billingRequest);
```