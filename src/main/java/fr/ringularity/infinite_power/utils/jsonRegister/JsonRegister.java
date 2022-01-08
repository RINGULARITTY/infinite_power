package fr.ringularity.infinite_power.utils.jsonRegister;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static fr.ringularity.infinite_power.InfinitePower.MOD_ID;

public class JsonRegister {
    private static final ArrayList<JsonBlockRegister> JSON_BLOCK_REGISTERS = new ArrayList<>();
    private static final ArrayList<JsonItemRegister> JSON_ITEM_REGISTERS = new ArrayList<>();
    private static final ArrayList<JsonItemGroupRegister> JSON_ITEM_GROUP_REGISTERS = new ArrayList<>();
    private static boolean log = false;

    private static String path = "";

    public static void setResourcesFolderPath(String folderPath) {
        path = folderPath;
    }

    public static void addBlock(String nameId, String name, String customTextureFolder, boolean customBlockModel, boolean customItemModel) {
        JSON_BLOCK_REGISTERS.add(new JsonBlockRegister(nameId, name, customTextureFolder, customBlockModel, customItemModel));
    }

    public static void addCustomLootsBlock(String nameId, String name, String customTextureFolder, boolean customBlockModel, boolean customItemModel) {
        JSON_BLOCK_REGISTERS.add(new JsonBlockRegister(nameId, name, customTextureFolder, customBlockModel, customItemModel));
    }

    public static void addItem(String nameId, String name, String customTextureFolder, boolean customItemModel) {
        JSON_ITEM_REGISTERS.add(new JsonItemRegister(nameId, name, customTextureFolder, customItemModel));
    }

    public static void addItemGroup(String nameId, String name) {
        JSON_ITEM_GROUP_REGISTERS.add(new JsonItemGroupRegister(nameId, name));
    }

    public static void enableLog() {
        log = true;
    }


    public static void createJsonFiles() {

        System.out.println("[Json File Creator Main] : Initialization...");
        final String assetsPath = path + "/assets/" + MOD_ID + "/", dataPath = path + "/data/" + MOD_ID + "/";
        System.out.println("[Json File Creator Main] : " + JSON_BLOCK_REGISTERS.size() + " blocks to register, " + JSON_ITEM_REGISTERS.size() + " items to register, " + JSON_ITEM_GROUP_REGISTERS.size() + " tabs to register");
        System.out.println("[Json File Creator Main] : 1/4 blockStates...");
        createBlockStates(assetsPath);
        System.out.println("[Json File Creator Main] : 2/4 models...");
        createModels(assetsPath);
        System.out.println("[Json File Creator Main] : 3/4 lang...");
        createLang(assetsPath);
        System.out.println("[Json File Creator Main] : 4/4 lootTables...");
        //createLootTables(dataPath);a
        System.out.println("[Json File Creator Main] : Finished !");

        Scanner sc = new Scanner(System.in);
        System.out.println("Continue to load ?\n");
        final int choice = sc.nextInt();
        if (choice == 0)
            System.exit(0);
    }


    private static void createBlockStates(final String assetsPath) {
        //deleteDirectory(assetsPath + "blockstates");
        for (final JsonBlockRegister jbr : JSON_BLOCK_REGISTERS) {
            final String blockStateContent = jbr.getBlockStateContent();
            if (!Objects.equals(blockStateContent, "")) {
                final String fileName = assetsPath + "blockstates/" + jbr.getNameId() + ".json";
                try {
                    FileWriter blockStateFile = new FileWriter(fileName);
                    blockStateFile.write(blockStateContent);
                    blockStateFile.close();
                    if (log)
                        System.out.println("[Json File Creator] : " + "Successfully created blockstate of " + jbr.getNameId() + " block (" + fileName + ")");
                } catch (IOException e) {
                    System.out.println("Error with BlockState file of " + jbr.getNameId());
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createModels(final String assetsPath) {
        //deleteDirectory(assetsPath + "models\\block");
        //deleteDirectory(assetsPath + "models\\item");
        for (final JsonBlockRegister jbr : JSON_BLOCK_REGISTERS) {
            final String blockModelContentBlock = jbr.getBlockModelContent(), blockModelContentItem = jbr.getItemModelContent();
            if (!Objects.equals(blockModelContentBlock, "")) {
                final String fileName = assetsPath + "models/block/" + jbr.getNameId() + ".json";
                try {
                    FileWriter blockModelFileBlock = new FileWriter(fileName);
                    blockModelFileBlock.write(blockModelContentBlock);
                    blockModelFileBlock.close();
                    if (log)
                        System.out.println("[Json File Creator] : " + "Successfully created model of " + jbr.getNameId() + " block (" + fileName + ")");
                } catch (IOException e) {
                    System.out.println("Error with BlockModel block file for " + jbr.getNameId());
                    e.printStackTrace();
                }
            }
            if (!Objects.equals(blockModelContentItem, "")) {
                final String fileName = assetsPath + "models/item/" + jbr.getNameId() + ".json";
                try {
                    FileWriter blockModelFileItem = new FileWriter(fileName);
                    blockModelFileItem.write(blockModelContentItem);
                    blockModelFileItem.close();
                    if (log)
                        System.out.println("[Json File Creator] : " + "Successfully created model item of " + jbr.getNameId() + " block (" + fileName + ")");
                } catch (IOException e) {
                    System.out.println("Error with BlockModel item file for " + jbr.getNameId());
                    e.printStackTrace();
                }
            }
        }
        for (final JsonItemRegister jir : JSON_ITEM_REGISTERS) {
            final String itemModelContent = jir.getItemModelContent();
            if (!Objects.equals(itemModelContent, "")) {
                final String fileName = assetsPath + "models/item/" + jir.getNameId() + ".json";
                try {
                    FileWriter itemModelFile = new FileWriter(fileName);
                    itemModelFile.write(itemModelContent);
                    itemModelFile.close();
                    if (log)
                        System.out.println("[Json File Creator] : " + "Successfully created model of " + jir.getNameId() + " item (" + fileName + ")");
                } catch (IOException e) {
                    System.out.println("Error with ItemModel file for " + jir.getNameId());
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createLang(final String assetsPath) {
        StringBuilder langContent = new StringBuilder("{\n");
        for (final JsonBlockRegister jbr : JSON_BLOCK_REGISTERS)
            langContent.append("\t").append(jbr.getLangContent()).append(",\n");
        for (final JsonItemRegister jir : JSON_ITEM_REGISTERS)
            langContent.append("\t").append(jir.getLangContent()).append(",\n");
        for (final JsonItemGroupRegister jigr : JSON_ITEM_GROUP_REGISTERS) {
            langContent.append("\t").append(jigr.getLangContent()).append(",\n");
        }
        if (!langContent.toString().equals("{\n"))
            langContent = new StringBuilder(langContent.substring(0, langContent.length() - 2) + "\n}");
        else
            langContent = new StringBuilder();
        try {
            FileWriter langFile = new FileWriter(assetsPath + "lang/en_us.json");
            langFile.write(langContent.toString());
            langFile.close();
        } catch (IOException e) {
            System.out.println("Error with lang file");
            e.printStackTrace();
        }
    }

    private static void createLootTables(final String dataPath) {
        //deleteDirectory(dataPath + "loot_tables\\block");
        for (final JsonBlockRegister jbr : JSON_BLOCK_REGISTERS) {
            try {
                FileWriter lootFileBlock = new FileWriter(dataPath + "loot_tables/blocks/" + jbr.getNameId() + ".json");
                lootFileBlock.write(jbr.getAllLootContent());
                lootFileBlock.close();
            } catch (IOException e) {
                System.out.println("Error with LootTable block file for " + jbr.getNameId());
                e.printStackTrace();
            }
        }
    }

    private static void deleteDirectory(String emplacement) {
        File folder = new File(emplacement);
        if (folder.exists())  {
            File[] files = folder.listFiles();
            if (Objects.isNull(files))
                return;
            for (File file : files) {
                if (file.isDirectory())
                    deleteDirectory(folder + "/" + file);
                if (file.delete())
                    return;
            }
        }
    }
}
