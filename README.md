# DogBreeds SDK

This is a simple Android SDK for fetching dog breeds data from a public API. The SDK allows you to get various information about dog breeds, including images, height, weight, and more. It also provides functionality for retrieving specific breed details based on breed name, gender, and age.

## Installation

To include this SDK in your Android project, add the following dependencies:

1. In your root `build.gradle` file at the end of the repositories:

```
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

2. Add the dependency:

```
dependencies {
    implementation("com.github.YakirKashani:DogsBreeds:1.0.2")
}
```

## Usage

### 1. Fetch All Dog Breeds

To fetch all dog breeds, use the following code:

```
DogData.getAllDogsData(context, new DogData.Callback_Data<List<DogModel>>() {
    @Override
    public void data(List<DogModel> dogs) {
        // Handle the list of dog breeds
    }
});
```

### 2. Fetch All Breeds with Images

To get a list of breeds with their corresponding images, use the following code:

```
DogData.getAllDogsAndUrls(context, new DogData.Callback_Data<List<BreedAndUrlModel>>() {
    @Override
    public void data(List<BreedAndUrlModel> breedAndUrlModels) {
        // Handle the list of breed names and URLs
    }
});
```

### 3. Fetch Dog Breed Details by Breed, Gender, and Age

To fetch a specific dog breed's data based on breed name, gender, and age, use the following code:

```
DogData.getDogByBreedGenderAge(context, "bulldog", "male", "puppy", new DogData.Callback_Data<DogModel>() {
    @Override
    public void data(DogModel dog) {
        // Handle the specific dog's data
    }
});
```

## Models

### DogModel

The `DogModel` class contains the details of a dog breed, including:

- `id`: The unique identifier for the breed.
- `breed_name`: The name of the breed.
- `gender`: The gender of the breed.
- `from_age`: The minimum age for the breed.
- `to_age`: The maximum age for the breed.
- `avg_height_min`: The minimum height of the breed.
- `avg_height_max`: The maximum height of the breed.
- `avg_weight_min`: The minimum weight of the breed.
- `avg_weight_max`: The maximum weight of the breed.
- `avg_drink`: The average amount of water the breed drinks.
- `avg_food`: The average amount of food the breed consumes.
- `created_at`: The creation date of the breed data.
- `updated_at`: The last update date of the breed data.
- `pic_url`: The URL to the image of the breed. (fixed in version 1.0.2)

### BreedAndUrlModel

The `BreedAndUrlModel` class contains the breed's name and its corresponding image URL:

- `breed_name`: The name of the breed.
- `pic_url`: The URL of the breed's image. (fixed in version 1.0.2)

## API

This SDK interacts with a public API to retrieve dog breed data. The available endpoints are:

1. **/dogs_data/all**: Fetch all dog breeds.
2. **/dogs_data/BreedsAndUrl**: Fetch all breeds with their image URLs.
3. **/dogs_data/{breed_name}/{gender}/{age}**: Fetch data for a specific breed based on breed name, gender, and age.

## Callback Interfaces

The SDK uses callback interfaces to handle the asynchronous API responses:

- **CallbackDogData**: Used for fetching data for a specific dog breed.
- **CallbackBreedsAndUrl**: Used for fetching a list of breeds and their image URLs.
- **CallbackAllDogsData**: Used for fetching a list of all dog breeds.
